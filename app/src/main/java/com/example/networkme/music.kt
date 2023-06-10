package com.example.networkme

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.example.networkme.databinding.FragmentMusicBinding


class music : Fragment() {
    private lateinit var binding : FragmentMusicBinding
    private var mediaController: MediaController? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var songList: ArrayList<MusicModel>
    private lateinit var songAdapter: MusicAdapter

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMusicBinding.inflate(inflater, container, false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showFavoriteVideo()

        val layoutManager2 = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvMusic)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager2

        songList = ArrayList()
        tambahDataLagu()

        songAdapter = MusicAdapter(songList)
        recyclerView.adapter = songAdapter
    }

    private fun showFavoriteVideo() {
        binding.apply {
            if (mediaController == null) {
                mediaController = MediaController(activity)
                mediaController!!.setAnchorView(this.videoView)
            }

            videoView.setMediaController(mediaController)
            videoView.setVideoURI(Uri.parse("android.resource://com.example.networkme/" + R.raw.videoplayback))
            videoView.requestFocus()
            videoView.start()

            videoView.setOnErrorListener { _, _, _ ->
                Toast.makeText(activity, "Error Occurred", Toast.LENGTH_LONG).show()
                false
            }
        }
    }

    private fun tambahDataLagu(){
        songList.add((MusicModel("I Belong to You","Jacob Lee",R.drawable.music1)))
        songList.add((MusicModel("Warmness on The Soul","Avenged Sevenfold",R.drawable.music2)))
        songList.add((MusicModel("Your Call","Secondhand Serenade",R.drawable.music3)))
        songList.add((MusicModel("Home","Michael Buble",R.drawable.music4)))
    }
}
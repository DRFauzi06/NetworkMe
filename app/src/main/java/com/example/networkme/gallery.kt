package com.example.networkme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class gallery : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var gambarList: ArrayList<GalleryModel>
    private lateinit var gambarAdapter: GalleryAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val layoutManager = LinearLayoutManager(context)

        val layoutManager = GridLayoutManager(context, 2)
        recyclerView = view.findViewById(R.id.recycleGallery)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager

        gambarList = ArrayList()
        tambahData()





        gambarAdapter = GalleryAdapter(gambarList)
        recyclerView.adapter = gambarAdapter
    }

    private fun tambahData(){
        gambarList.add(GalleryModel(R.drawable.me))
        gambarList.add(GalleryModel(R.drawable.me2))
        gambarList.add(GalleryModel(R.drawable.me3))
        gambarList.add(GalleryModel(R.drawable.me4))
    }
}
package com.example.networkme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter(private val songList:ArrayList<MusicModel>) :
    RecyclerView.Adapter<MusicAdapter.CardViewViewHolder>() {

    class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.album)
        val namaPenyanyi: TextView = itemView.findViewById(R.id.singer)
        val judulLagu: TextView = itemView.findViewById(R.id.song)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val gambar = songList[position]
        holder.imageView.setImageResource(gambar.image)
        holder.namaPenyanyi.setText(gambar.band)
        holder.judulLagu.setText(gambar.judul)
    }
}

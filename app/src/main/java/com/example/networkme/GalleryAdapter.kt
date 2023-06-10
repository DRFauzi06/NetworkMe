package com.example.networkme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class GalleryAdapter(private val gambarList:ArrayList<GalleryModel>):
    RecyclerView.Adapter<GalleryAdapter.GambarViewHolder>() {

        class GambarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val imageView : ImageView = itemView.findViewById(R.id.galleryPic)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GambarViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pic , parent , false)
            return GambarViewHolder(view)
        }

        override fun getItemCount(): Int {
            return gambarList.size
        }

        override fun onBindViewHolder(holder: GambarViewHolder, position: Int) {
            val gambar = gambarList[position]
            holder.imageView.setImageResource(gambar.image)
        }
}
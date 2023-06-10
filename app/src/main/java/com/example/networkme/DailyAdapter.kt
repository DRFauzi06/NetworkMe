package com.example.networkme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DailyAdapter (private val gambarList:ArrayList<DailyModel>):
    RecyclerView.Adapter<DailyAdapter.CardViewViewHolder>() {

    class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val kegiatan: TextView = itemView.findViewById(R.id.activity)
        val waktu: TextView = itemView.findViewById(R.id.time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_daily, parent, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gambarList.size
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val gambar = gambarList[position]
        holder.kegiatan.setText(gambar.kegiatan)
        holder.waktu.setText(gambar.waktu)
    }
    }

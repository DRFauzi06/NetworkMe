package com.example.networkme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class dailyAct : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var gambarList: ArrayList<FriendModel>
    private lateinit var gambarAdapter: FriendAdapter
    private lateinit var dailyList:ArrayList<DailyModel>
    private lateinit var dailyAdapter: DailyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily_act, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

//        val layoutManager = GridLayoutManager(context, 2)
        recyclerView = view.findViewById(R.id.rvFriend)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager


        gambarList = ArrayList()
        tambahDataTeman()





        gambarAdapter = FriendAdapter(gambarList)

        recyclerView.adapter = gambarAdapter


        val layoutManager2 = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvDaily)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager2

        dailyList = ArrayList()
        tambahDataKegiatan()

        dailyAdapter = DailyAdapter((dailyList))
        recyclerView.adapter = dailyAdapter

    }

    private fun tambahDataTeman(){
        gambarList.add(FriendModel("Aqshal",R.drawable.friendaqshal))
        gambarList.add(FriendModel("Gigih",R.drawable.friendgigih))
        gambarList.add(FriendModel("Hadi",R.drawable.friendhadi))
        gambarList.add(FriendModel("Nabila",R.drawable.friendnabila))
        gambarList.add(FriendModel("Sabrina",R.drawable.friendsabrina))
        gambarList.add(FriendModel("Nuri",R.drawable.friendnuri))

    }
    private fun tambahDataKegiatan(){
        dailyList.add((DailyModel("Bangun Tidur","06.00")))
        dailyList.add((DailyModel("Mandi","06.15")))
        dailyList.add((DailyModel("Makan","06.45")))
        dailyList.add((DailyModel("Berangkat","07.30")))
        dailyList.add((DailyModel("Kuliah","09.30")))
        dailyList.add((DailyModel("Pulang","16.30")))
    }
}
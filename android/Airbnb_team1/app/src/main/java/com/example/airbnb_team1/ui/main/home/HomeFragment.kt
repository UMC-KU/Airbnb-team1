package com.example.airbnb_team1.ui.main.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.airbnb_team1.R
import com.example.airbnb_team1.data.remote.data.DataRetrofitClass
import com.example.airbnb_team1.databinding.FragmentHomeBinding
import com.example.airbnb_team1.ui.BaseFragment
import okhttp3.internal.notify


class HomeFragment() : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate), CompletionListener {

    var selectMenuList = ArrayList<HomeSelectedMenuData>()
    lateinit var detailRVAdapter: HomeDetailRVAdapter
    val dataRetrofitClass = DataRetrofitClass()

    override fun initAfterBinding() {
        initSelectMenuList()
        dataRetrofitClass.getAll(this)

        val menuAdapter = HomeSelectMenuRVAdapter(selectMenuList)
        binding.homeSelectMenuRv.adapter = menuAdapter
        binding.homeSelectMenuRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        menuAdapter.setMyItemClickListener(object : HomeSelectMenuRVAdapter.OnItemClickListener {
            override fun onItemClick(selectedMenu: HomeSelectedMenuData) {


            }
        })

        detailRVAdapter = HomeDetailRVAdapter()
        binding.homeInfoRv.adapter = detailRVAdapter
        binding.homeInfoRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        detailRVAdapter.setMyItemClickListener(object : HomeDetailRVAdapter.OnItemClickListener {
            override fun onItemClick(detailData: HomeDetailData) {

            }
        })


    }


    fun initSelectMenuList() {
        val temp = arrayListOf<HomeSelectedMenuData>(
            HomeSelectedMenuData(R.drawable.island, resources.getString(R.string.search_island)),
            HomeSelectedMenuData(R.drawable.park, resources.getString(R.string.search_park)),
            HomeSelectedMenuData(R.drawable.ufo, resources.getString(R.string.search_ufo)),
            HomeSelectedMenuData(R.drawable.parasol, resources.getString(R.string.search_parasol)),
            HomeSelectedMenuData(R.drawable.small_home, resources.getString(R.string.search_small_home)),
            HomeSelectedMenuData(R.drawable.design, resources.getString(R.string.search_design)),
            HomeSelectedMenuData(R.drawable.a_home, resources.getString(R.string.search_a_home)),
            HomeSelectedMenuData(R.drawable.camping, resources.getString(R.string.search_camping)),
            HomeSelectedMenuData(R.drawable.hosu, resources.getString(R.string.search_hosu)),
            HomeSelectedMenuData(R.drawable.north, resources.getString(R.string.search_north)),
            HomeSelectedMenuData(R.drawable.pool, resources.getString(R.string.search_pool))
        )
        selectMenuList.addAll(temp)
    }

    override fun loadComplete(data: ArrayList<HomeDetailData>) {
        detailRVAdapter.setList(data)
        detailRVAdapter.notifyDataSetChanged()
    }


}
package com.example.airbnb_team1.ui.main.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.airbnb_team1.R
import com.example.airbnb_team1.databinding.FragmentHomeBinding
import com.example.airbnb_team1.ui.BaseFragment


class HomeFragment(): BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    val selectMenuList = ArrayList<HomeSelectedMenuData>()
    val detailDataList = ArrayList<HomeDetailData>()
    override fun initAfterBinding() {
        initSelectMenuList()
        initDetailDataList()

        val menuAdapter = HomeSelectMenuRVAdapter(selectMenuList)

        binding.homeSelectMenuRv.adapter = menuAdapter
        binding.homeSelectMenuRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        menuAdapter.setMyItemClickListener(object : HomeSelectMenuRVAdapter.OnItemClickListener {
            override fun onItemClick(selectedMenu: HomeSelectedMenuData) {

            }
        })

        val detailRVAdapter = HomeDetailRVAdapter(detailDataList)
        binding.homeInfoRv.adapter = detailRVAdapter
        binding.homeInfoRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        detailRVAdapter.setMyItemClickListener(object : HomeDetailRVAdapter.MyItemClickListener{
            override fun onItemClick(detailData: HomeDetailData) {

            }
        })


    }


    fun initSelectMenuList(){
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

    fun initDetailDataList(){
        val temp = arrayListOf<HomeDetailData>(
            HomeDetailData("url", "name", "nation", "period", 123, 123),
            HomeDetailData("url", "name", "nation", "period", 123, 123),
            HomeDetailData("url", "name", "nation", "period", 123, 123),
            HomeDetailData("url", "name", "nation", "period", 123, 123)
        )

        detailDataList.addAll(temp)

    }
}
package com.example.airbnb_team1.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.airbnb_team1.databinding.ItemDetailInfoBinding

class HomeDetailRVAdapter(var detailDataList: ArrayList<HomeDetailData>) : RecyclerView.Adapter<HomeDetailRVAdapter.ViewHolder>(){
    interface MyItemClickListener {
        fun onItemClick(detailData: HomeDetailData)
    }

    private lateinit var mItemClickListener: MyItemClickListener
    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    inner class ViewHolder(val binding: ItemDetailInfoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(detailData: HomeDetailData) {
            binding.itemDetailInfoNameTv.text = detailData.name
            binding.itemDetailInfoNationTv.text = detailData.nation
            binding.itemDetailInfoPeriodTv.text = detailData.period
            binding.itemDetailInfoPriceOneTv.text = "₩${detailData.priceOne} /박"
            binding.itemDetailInfoPriceAllTv.text = "총액 ₩${detailData.priceAll}"
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeDetailRVAdapter.ViewHolder {
        val binding = ItemDetailInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeDetailRVAdapter.ViewHolder, position: Int) {
        holder.bind(detailDataList[position])
        holder.itemView.setOnClickListener { mItemClickListener.onItemClick(detailDataList[position]) }
    }

    override fun getItemCount(): Int {
        return detailDataList.size
    }


}
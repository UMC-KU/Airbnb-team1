package com.example.airbnb_team1.ui.main.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.airbnb_team1.databinding.ItemDetailInfoBinding

class HomeDetailRVAdapter(var detailDataList: ArrayList<HomeDetailData>) : RecyclerView.Adapter<HomeDetailRVAdapter.ViewHolder>(){
    lateinit var context: Context
    interface OnItemClickListener {
        fun onItemClick(detailData: HomeDetailData)
    }

    private lateinit var mItemClickListener: OnItemClickListener
    fun setMyItemClickListener(itemClickListener: OnItemClickListener) {
        mItemClickListener = itemClickListener
    }

    inner class ViewHolder(val binding: ItemDetailInfoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(detailData: HomeDetailData) {
            binding.itemDetailInfoNameTv.text = detailData.name
            binding.itemDetailInfoNationTv.text = detailData.address
            binding.itemDetailInfoPriceOneTv.text = "₩${detailData.price} /박"
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeDetailRVAdapter.ViewHolder {
        val binding = ItemDetailInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeDetailRVAdapter.ViewHolder, position: Int) {
        holder.bind(detailDataList[position])
        holder.binding.itemDetailInfoCl.setOnClickListener {
            mItemClickListener.onItemClick(detailDataList[position])
        }

        Glide.with(context)
            .load(detailDataList[position].imgData[0].url)
            .into(holder.binding.itemDetailPicIv)


        holder.binding.itemDetailPicIv.setOnClickListener {
            mItemClickListener.onItemClick(detailDataList[position])
        }
    }

    override fun getItemCount(): Int {
        return detailDataList.size
    }


}

package com.example.airbnb_team1.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.airbnb_team1.databinding.ItemSelectMenuBinding

class HomeSelectMenuRVAdapter(var selectMenuList: ArrayList<HomeSelectedMenuData>): RecyclerView.Adapter<HomeSelectMenuRVAdapter.ViewHolder>() {
    interface OnItemClickListener{
        fun onItemClick(selectedMenu: HomeSelectedMenuData)
    }

    private lateinit var mItemClickListener: OnItemClickListener
    fun setMyItemClickListener(itemClickListener: OnItemClickListener) {
        mItemClickListener = itemClickListener
    }


    inner class ViewHolder(val binding: ItemSelectMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(selectedMenu: HomeSelectedMenuData) {
            binding.homeSelectMenuIv.setImageResource(selectedMenu.img)
            binding.homeSelectMenuTv.text = selectedMenu.text
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSelectMenuRVAdapter.ViewHolder {
        val binding = ItemSelectMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeSelectMenuRVAdapter.ViewHolder, position: Int) {
        holder.bind(selectMenuList[position])
        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(selectMenuList[position])
        }
    }

    override fun getItemCount(): Int {
        return selectMenuList.size
    }

}
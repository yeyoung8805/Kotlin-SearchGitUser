package com.yyk.searchgituser.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yyk.searchgituser.data.Data
import com.yyk.searchgituser.data.UserData
import com.yyk.searchgituser.databinding.ItemListBinding

//class RecyclerViewAdapter(private val items : ArrayList<UserData>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    var datalist = mutableListOf<Data>()
    inner class MyViewHolder(private val binding : ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userData: Data){
            binding.user = userData

            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])
    }
}
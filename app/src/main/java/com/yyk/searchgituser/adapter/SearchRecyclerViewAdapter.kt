package com.yyk.searchgituser.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yyk.searchgituser.data.Data
import com.yyk.searchgituser.databinding.ItemListBinding

//class RecyclerViewAdapter(private val items : ArrayList<UserData>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
class SearchRecyclerViewAdapter : ListAdapter<Data, SearchRecyclerViewAdapter.MyViewHolder>(diffUtil) {

    var onClickLikeBtn: ((Int) -> Unit)? = null
    inner class MyViewHolder(private val binding : ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Data, position: Int){
            binding.user = data
            binding.btnLike.setOnClickListener {
                onClickLikeBtn?.invoke(position)
                Log.e("yyk binding Listener :: ", "$position")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

//    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.bind(getItem(position))
        holder.apply {
            bind(getItem(position), position)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                Log.e("yyk : ", "areItemsTheSame = ${oldItem==newItem}")
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                Log.e("yyk : ", "areContentsTheSame = $oldItem $newItem")
                return oldItem.login == newItem.login
            }
        }
    }
}
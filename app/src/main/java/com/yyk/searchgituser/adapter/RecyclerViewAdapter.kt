package com.yyk.searchgituser.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yyk.searchgituser.R
import com.yyk.searchgituser.data.Data
import com.yyk.searchgituser.data.UserData
import com.yyk.searchgituser.databinding.ItemListBinding

//class RecyclerViewAdapter(private val items : ArrayList<UserData>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
class RecyclerViewAdapter : ListAdapter<Data, RecyclerViewAdapter.MyViewHolder>(diffUtil) {

    inner class MyViewHolder(private val binding : ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userData: Data){
            binding.user = userData
            binding.itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
//                    Navigation.findNavController(v).navigate(R.id.action_search_screen_to_star_screen)
//                    binding.btnLike.setBackgroundColor(Color.BLACK)
                    binding.btnLike.setBackgroundColor(Color.parseColor("#FF000000")) //TODO 변경 안됨..
                    //TODO Room 적용해야 함

                }
            })
            binding.executePendingBindings()
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
            bind(getItem(position))
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                Log.e("RecyclerViewAdapter : ", "areItemsTheSame = ${oldItem==newItem}")
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                Log.e("RecyclerViewAdapter : ", "areContentsTheSame = $oldItem $newItem")
                return oldItem.id == newItem.id
            }
        }
    }
}
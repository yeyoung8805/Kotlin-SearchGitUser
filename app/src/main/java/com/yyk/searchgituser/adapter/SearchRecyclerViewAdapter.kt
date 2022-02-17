package com.yyk.searchgituser.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yyk.searchgituser.data.Data
import com.yyk.searchgituser.databinding.ItemListBinding
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class SearchRecyclerViewAdapter @Inject constructor(@ActivityContext context: Context):
    ListAdapter<Data, SearchRecyclerViewAdapter.MyViewHolder>(diffUtil) {

    var onClickLikeBtn: ((Int) -> Unit)? = null

    inner class MyViewHolder(private val binding : ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data){
            binding.user = data
            binding.btnLike.setOnClickListener {
                onClickLikeBtn?.invoke(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            bind(getItem(position))
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
                return oldItem.html_url == newItem.html_url
            }
        }
    }
}
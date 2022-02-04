package com.yyk.searchgituser.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yyk.searchgituser.data.Data

object BindingAdapter {

    @BindingAdapter("items")
    @JvmStatic
    fun RecyclerView.setItems(gitUserList : ArrayList<Data>?) {
        (this.adapter as? RecyclerViewAdapter)?.submitList(gitUserList?.toMutableList())
    }

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun ImageView.loadImage(imageUrl : String) {
        Glide.with(context)
                .load(imageUrl)
                .error(com.yyk.searchgituser.R.drawable.ic_launcher_foreground)
                .into(this)
    }
}
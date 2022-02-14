package com.yyk.searchgituser.data

import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

//class UserData {
//    val user_image: Drawable?,
//    val user_image: String,
//    val user_id: String,
//    val user_url: String

//    @SerializedName("avatar_url")
//    val avatar_url: String,
//    @SerializedName("login")
//    val login: String,
//    @SerializedName("url")
//    val url: String

//    data class UserInfo(
    data class UserData(
        @Expose
        @SerializedName("total_count")
        val total_count: Int,
        @Expose
        @SerializedName("incomplete_results")
        val incomplete_results: Boolean,
        @Expose
        @SerializedName("items")
        val items : ArrayList<Data>
        )

    @Entity(tableName = "git_user_table")
    data class Data(
        @Expose
        @SerializedName("login")
        @PrimaryKey
        @ColumnInfo(name = "login")
        val login: String,
        @Expose
        @SerializedName("avatar_url")
        @ColumnInfo(name = "avatar_url")
        val avatar_url: String,
        @Expose
        @SerializedName("html_url")
        @ColumnInfo(name = "html_url")
        val html_url: String
    )
//}

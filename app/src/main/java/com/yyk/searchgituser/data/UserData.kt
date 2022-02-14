package com.yyk.searchgituser.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

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
        @ColumnInfo(name = "id")
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

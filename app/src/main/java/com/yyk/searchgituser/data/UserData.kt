package com.yyk.searchgituser.data

import android.graphics.drawable.Drawable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

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

    data class Data(
        @Expose
        @SerializedName("login")
        val login: String,
        @Expose
        @SerializedName("id")
        val id: Int,
        @Expose
        @SerializedName("node_id")
        val node_id: String,
        @Expose
        @SerializedName("avatar_url")
        val avatar_url: String,
        @Expose
        @SerializedName("gravatar_id")
        val gravatar_id: String,
        @Expose
        @SerializedName("url")
        val url: String,
        @Expose
        @SerializedName("html_url")
        val html_url: String,
        @Expose
        @SerializedName("followers_url")
        val followers_url: String,
        @Expose
        @SerializedName("subscriptions_url")
        val subscriptions_url: String,
        @Expose
        @SerializedName("organizations_url")
        val organizations_url: String,
        @Expose
        @SerializedName("repos_url")
        val repos_url: String,
        @Expose
        @SerializedName("received_events_url")
        val received_events_url: String,
        @Expose
        @SerializedName("type")
        val type: String,
        @Expose
        @SerializedName("score")
        val score: Int,
        @Expose
        @SerializedName("following_url")
        val following_url: String,
        @Expose
        @SerializedName("gists_url")
        val gists_url: String,
        @Expose
        @SerializedName("starred_url")
        val starred_url: String,
        @Expose
        @SerializedName("events_url")
        val events_url: String,
        @Expose
        @SerializedName("site_admin")
        val site_admin: Boolean
    )
//}

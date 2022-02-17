package com.yyk.searchgituser.`interface`

import android.text.Editable
import com.yyk.searchgituser.data.UserData
import retrofit2.Call
import retrofit2.http.*

interface SearchGitUserInterface {

//    @GET("/search/users")
//    fun getInfoByUsername(
//        @Header("accept") acceptSetting : String,
//        @Query("q") keyword :String,
//        @Query("sort") sort : String,
//        @Query("order") order : String,
//        @Query("per_page") per_page : Int,
//        @Query("page") page : Int
//    ): Call<UserData>

//    @GET("/search/users")
//    fun getInfoByUsername(
//        @Query("q") keyword: String
//    ): Call<UserData>

    @GET("/search/users")
    suspend fun getInfoByUsername(
        @Query("q") keyword: String?
    ): UserData

}
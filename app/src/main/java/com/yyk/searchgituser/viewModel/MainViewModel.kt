package com.yyk.searchgituser.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yyk.searchgituser.`interface`.SearchGitUserInterface
import com.yyk.searchgituser.data.Data
import com.yyk.searchgituser.data.UserData
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel() : ViewModel() {
    // TODO:: Retrofit SingleTone
    //
    val enterTxt = MutableLiveData<String>("")
    val result = MutableLiveData<MutableList<Data>>()

    fun getUserData() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor {
                    it.proceed(
                            it.request()
                                    .newBuilder()
                                    .addHeader("accept", "application/vnd.github.v3+json")
                                    .build()
                    )
                }.build())
                .build()

        val api = retrofit.create(SearchGitUserInterface::class.java)

//        api.getInfoByUsername(enterTxt.value!!).enqueue(object : Callback<UserData> {
//            override fun onFailure(call: Call<UserData>, t: Throwable) {
//            }
//
//            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
//                result.value = response.body()!!.items.toMutableList()
//            }
//        })
        viewModelScope.launch {
            result.value = api.getInfoByUsername(enterTxt.value!!).items.toMutableList()
        }
    }
}
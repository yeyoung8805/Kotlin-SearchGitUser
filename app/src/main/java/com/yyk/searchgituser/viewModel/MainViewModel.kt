package com.yyk.searchgituser.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
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

class MainViewModel : ViewModel() {
    // TODO:: Retrofit SingleTone
    //
    val enterTxt = MutableLiveData<String>("")
    val result = MutableLiveData<ArrayList<Data>>()
    val gitUsers : LiveData<ArrayList<Data>> = result
    var items : ArrayList<Data> = arrayListOf()

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

        viewModelScope.launch {
            //방법1
//            result.value = api.getInfoByUsername(enterTxt.value!!).items.toMutableList()

            //방법2
            val resultValue = api.getInfoByUsername(enterTxt.value.toString())
            result.value = (resultValue.items)
        }
    }
}
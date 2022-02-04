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
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainViewModel : ViewModel() {
    // TODO:: Retrofit SingleTon
    //
    val enterTxt = MutableLiveData<String>("")
    private val result = MutableLiveData<ArrayList<Data>?>(null)
    val gitUsers: LiveData<ArrayList<Data>?> = result
    var items: ArrayList<Data> = arrayListOf()

    fun getUserData() {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor {
                it.proceed(
                    it.request()
                        .newBuilder()
//                        .addHeader("accept", "application/vnd.github.v3+json")
                        .build()
                )
            }
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val api = retrofit.create(SearchGitUserInterface::class.java)
        Log.e("PARK", "------START")
        viewModelScope.launch {
            //방법1
//            result.value = api.getInfoByUsername(enterTxt.value!!).items.toMutableList()

            //방법2
            Log.e("PARK", "------ ${enterTxt.value.toString()}")
            try {
                val resultValue = api.getInfoByUsername(enterTxt.value.toString())
                Log.e("PARK", "------ ${resultValue}")
                result.value = resultValue.items

            } catch (e: Exception) {
                Log.e("PARK", e.message.toString())
            }
        }
    }
}
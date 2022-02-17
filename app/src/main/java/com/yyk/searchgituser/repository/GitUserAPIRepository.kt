package com.yyk.searchgituser.repository

import androidx.lifecycle.liveData
import com.yyk.searchgituser.`interface`.SearchGitUserInterface
import com.yyk.searchgituser.data.ResultStatus
import com.yyk.searchgituser.data.UserData
import com.yyk.searchgituser.di.NetworkModule
import java.lang.Exception
import javax.inject.Inject

class GitUserAPIRepository @Inject constructor(private val api: SearchGitUserInterface) {

    fun getGitUsers(id: String?)= liveData {
        emit(ResultStatus.Loading)
        try {
            val response = api.getInfoByUsername(id)
            emit(ResultStatus.Success(response))
        }catch (e: Exception){
            emit(ResultStatus.Error(e))
        }
    }
}
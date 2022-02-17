package com.yyk.searchgituser.repository

import androidx.lifecycle.liveData
import com.yyk.searchgituser.data.Data
import com.yyk.searchgituser.data.GitUserDao
import com.yyk.searchgituser.data.ResultStatus
import java.lang.Exception
import javax.inject.Inject

class GitUserDBRepository @Inject constructor(private val gitUserDao: GitUserDao) {

    fun selectAll() = liveData {
        emit(ResultStatus.Loading)
        try {
            val result = gitUserDao.getGitUserDB()
            emit(ResultStatus.Success(result))
        }catch (e: Exception) {
            emit(ResultStatus.Error(e))
        }
    }

    suspend fun insert(gitUser: Data?) = gitUserDao.insert(gitUser)

    fun deleteOne(gitUserId : String) = liveData {
        emit(ResultStatus.Loading)
        try {
            val result = gitUserDao.deleteUserDB(gitUserId)
            emit(ResultStatus.Success(result))
        }catch (e: Exception) {
            emit(ResultStatus.Error(e))
        }
    }
}
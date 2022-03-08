package com.yyk.searchgituser.repository

import androidx.lifecycle.liveData
import com.yyk.searchgituser.data.Data
import com.yyk.searchgituser.data.GitUserDao
import com.yyk.searchgituser.data.ResultStatus
import com.yyk.searchgituser.data.UserData
import java.lang.Exception
import javax.inject.Inject

class GitUserDBRepository @Inject constructor(private val gitUserDao: GitUserDao) {

//    fun selectAll() = liveData {
//        emit(ResultStatus.Loading)
//        try {
//            val result = gitUserDao.getGitUserDB()
//            emit(ResultStatus.Success(result))
//        }catch (e: Exception) {
//            emit(ResultStatus.Error(e))
//        }
//    }
//
//    suspend fun insert(gitUser: Data?) = gitUserDao.insert(gitUser)
//
//    fun deleteOne(gitUserId : String) = liveData {
//        emit(ResultStatus.Loading)
//        try {
//            val result = gitUserDao.deleteUserDB(gitUserId)
//            emit(ResultStatus.Success(result))
//        }catch (e: Exception) {
//            emit(ResultStatus.Error(e))
//        }
//    }

    fun selectAll() = gitUserDao.getGitUserDB()

    fun changeLikeStatus(position: Int, gitUsers: ArrayList<Data>?) = liveData {
        emit(ResultStatus.Loading)
        try {
            var gitUserDB = gitUsers?.get(position)
            if(!gitUserDB?.isLike!!) {
                gitUserDB?.isLike = true
                emit(ResultStatus.Success(gitUserDao.insert(gitUserDB)))
            }else {
                gitUserDB?.isLike = false
                emit(ResultStatus.Success(gitUserDao.deleteUserDB(gitUserDB.login)))
            }
        }catch (e: Exception) {
            emit(ResultStatus.Error(e))
        }
    }

    fun filterSearchResult(gitUserAPI : ArrayList<Data>) : ArrayList<Data> {
        val apiGitUsers: MutableSet<String> = mutableSetOf()
        val gitUsersDB: ArrayList<Data> = ArrayList(selectAll())

        for(i in gitUsersDB) {
            apiGitUsers.add(i.login)
        }
        for(i in gitUserAPI) {
            if(!apiGitUsers.add(i.login)) {
                i.isLike = true
            }
        }
        return gitUserAPI
    }
}
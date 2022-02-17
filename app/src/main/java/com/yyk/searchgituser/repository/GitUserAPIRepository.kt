package com.yyk.searchgituser.repository

import com.yyk.searchgituser.data.UserData
import com.yyk.searchgituser.module.RetrofitModule

class GitUserAPIRepository {
//    suspend fun getGitUsers(id:String?): UserData {
    suspend fun getGitUsers(id: String?): UserData {
        return RetrofitModule.service.getInfoByUsername(id)
    }
}
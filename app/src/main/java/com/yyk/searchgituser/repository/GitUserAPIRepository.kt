package com.yyk.searchgituser.repository

import com.yyk.searchgituser.`interface`.SearchGitUserInterface
import com.yyk.searchgituser.data.UserData
import com.yyk.searchgituser.di.NetworkModule
import javax.inject.Inject

class GitUserAPIRepository @Inject constructor(private val api: SearchGitUserInterface) {

    suspend fun getGitUsers(id: String?): UserData {
        return api.getInfoByUsername(id)
    }
}
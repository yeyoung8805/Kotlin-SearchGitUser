package com.yyk.searchgituser.repository

import com.yyk.searchgituser.data.Data
import com.yyk.searchgituser.data.GitUserDao
import javax.inject.Inject

class GitUserDBRepository @Inject constructor(private val gitUserDao: GitUserDao) {

    fun selectOne(gitUserDbId: String) = gitUserDao.getGitUserDB(gitUserDbId)

    fun selectAll() = gitUserDao.getGitUserDB()

    suspend fun insert(gitUser: Data?) = gitUserDao.insert(gitUser)
}
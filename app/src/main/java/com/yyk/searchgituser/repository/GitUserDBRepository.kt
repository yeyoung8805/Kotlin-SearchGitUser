package com.yyk.searchgituser.repository

import com.yyk.searchgituser.data.Data
import com.yyk.searchgituser.data.GitUserDao

class GitUserDBRepository(private val gitUserDao: GitUserDao) {

    fun selectOne(gitUserDbId: String) = gitUserDao.getGitUserDB(gitUserDbId)

    fun selectAll() = gitUserDao.getGitUserDB()

    suspend fun insert(gitUser: Data?) = gitUserDao.insert(gitUser)
}
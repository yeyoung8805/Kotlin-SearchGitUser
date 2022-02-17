package com.yyk.searchgituser.di

import com.yyk.searchgituser.`interface`.SearchGitUserInterface
import com.yyk.searchgituser.data.GitUserDao
import com.yyk.searchgituser.repository.GitUserAPIRepository
import com.yyk.searchgituser.repository.GitUserDBRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun bindGitUserApiRepo(api: SearchGitUserInterface) : GitUserAPIRepository {
        return GitUserAPIRepository(api)
    }

    @Provides
    fun bindGitUserLocalRepo(dao: GitUserDao) : GitUserDBRepository {
        return GitUserDBRepository(dao)
    }
}
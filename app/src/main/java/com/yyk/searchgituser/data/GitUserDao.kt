package com.yyk.searchgituser.data

import androidx.room.*

@Dao
interface GitUserDao {

    @Query("SELECT * FROM git_user_table id=:gitUserId")
    fun getGitUserDB(gitUserId: String): Data

    @Query("SELECT * FROM git_user_table ORDER BY id ASC")
    fun getGitUserDB(): List<Data>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(gitUser: Data?): Long

    @Update
    suspend fun update(gitUser: Data)

    @Delete
    suspend fun delete(gitUser: Data)

    @Query("DELETE FROM git_user_table WHERE id=:gitUserId")
    suspend fun deleteUserDB(gitUserId: String?): Int
}
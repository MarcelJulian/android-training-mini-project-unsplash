package com.example.miniproject.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.miniproject.model.UnsplashPhoto

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<UnsplashPhoto>)

    @Query("SELECT * FROM photos WHERE " +
            "query LIKE :queryString ")
    fun reposByQuery(queryString: String): PagingSource<Int, UnsplashPhoto>

    @Query("DELETE FROM photos")
    suspend fun clearRepos()
}
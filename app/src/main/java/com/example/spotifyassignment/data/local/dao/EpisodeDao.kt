package com.example.spotifyassignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spotifyassignment.model.local.EpisodeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EpisodeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(episodeEntity: EpisodeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(episodeEntities: List<EpisodeEntity>)

    @Query("delete from tbl_episode")
    suspend fun deleteAll(): Int

    @Query("select * from tbl_episode")
    fun getAllEpisodes(): Flow<List<EpisodeEntity>>

    @Query("select * from tbl_episode where id=:episodeId")
    fun getEpisodeById(episodeId: String): Flow<EpisodeEntity>
}
package com.example.spotifyassignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spotifyassignment.model.local.PlayListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(playListEntity: PlayListEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(playListEntities: List<PlayListEntity>)

    @Query("delete from tbl_playlist")
    suspend fun deleteAll(): Int

    @Query("select * from tbl_playlist")
    fun getAllPlayLists(): Flow<List<PlayListEntity>>

    @Query("select * from tbl_playlist where id=:playListId")
    fun getPlayListById(playListId: String): Flow<PlayListEntity>
}
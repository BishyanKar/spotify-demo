package com.example.spotifyassignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spotifyassignment.model.local.TrackEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(trackEntity: TrackEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(trackEntities: List<TrackEntity>)

    @Query("delete from tbl_track")
    suspend fun deleteAll(): Int

    @Query("select * from tbl_track")
    fun getAllTracks(): Flow<List<TrackEntity>>

    @Query("select * from tbl_track where id=:trackId")
    fun getTrackById(trackId: String): Flow<TrackEntity>
}
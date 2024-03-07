package com.example.spotifyassignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spotifyassignment.model.local.ShowEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(showEntity: ShowEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(showEntities: List<ShowEntity>)

    @Query("delete from tbl_show")
    suspend fun deleteAll(): Int

    @Query("select * from tbl_show")
    fun getAllShows(): Flow<List<ShowEntity>>

    @Query("select * from tbl_show where id=:showId")
    fun getShowById(showId: String): Flow<ShowEntity>
}
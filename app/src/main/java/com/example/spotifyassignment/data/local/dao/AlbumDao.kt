package com.example.spotifyassignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spotifyassignment.model.local.AlbumEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(albumEntity: AlbumEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(albumEntities: List<AlbumEntity>)

    @Query("delete from tbl_album")
    suspend fun deleteAll(): Int

    @Query("select * from tbl_album")
    fun getAllAlbums(): Flow<List<AlbumEntity>>

    @Query("select * from tbl_album where id=:albumId")
    fun getAlbumById(albumId: String): Flow<AlbumEntity>
}
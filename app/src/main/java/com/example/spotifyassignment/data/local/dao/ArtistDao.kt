package com.example.spotifyassignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spotifyassignment.model.local.ArtistEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(artistEntity: ArtistEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(artistEntities: List<ArtistEntity>)

    @Query("delete from tbl_artist")
    suspend fun deleteAll(): Int

    @Query("select * from tbl_artist")
    fun getAllArtists(): Flow<List<ArtistEntity>>

    @Query("select * from tbl_artist where id=:artistId")
    fun getArtistById(artistId: String): Flow<ArtistEntity>
}
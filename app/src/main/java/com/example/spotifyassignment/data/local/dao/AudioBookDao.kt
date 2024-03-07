package com.example.spotifyassignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spotifyassignment.model.local.AudioBookEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AudioBookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(audioBookEntity: AudioBookEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(audioBookEntities: List<AudioBookEntity>)

    @Query("delete from tbl_audio_book")
    suspend fun deleteAll(): Int

    @Query("select * from tbl_audio_book")
    fun getAllAudioBooks(): Flow<List<AudioBookEntity>>

    @Query("select * from tbl_audio_book where id=:audioBookId")
    fun getAudioBookById(audioBookId: String): Flow<AudioBookEntity>
}
package com.example.spotifyassignment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.spotifyassignment.data.local.dao.AlbumDao
import com.example.spotifyassignment.data.local.dao.ArtistDao
import com.example.spotifyassignment.data.local.dao.AudioBookDao
import com.example.spotifyassignment.data.local.dao.EpisodeDao
import com.example.spotifyassignment.data.local.dao.PlayListDao
import com.example.spotifyassignment.data.local.dao.ShowDao
import com.example.spotifyassignment.data.local.dao.TrackDao
import com.example.spotifyassignment.model.local.AlbumEntity
import com.example.spotifyassignment.model.local.ArtistEntity
import com.example.spotifyassignment.model.local.AudioBookEntity
import com.example.spotifyassignment.model.local.Converters
import com.example.spotifyassignment.model.local.EpisodeEntity
import com.example.spotifyassignment.model.local.PlayListEntity
import com.example.spotifyassignment.model.local.ShowEntity
import com.example.spotifyassignment.model.local.TrackEntity

@Database(
    entities = [
        AlbumEntity::class,
        ArtistEntity::class,
        AudioBookEntity::class,
        EpisodeEntity::class,
        PlayListEntity::class,
        ShowEntity::class,
        TrackEntity::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MusicDB: RoomDatabase() {
    abstract fun albumDao(): AlbumDao
    abstract fun artistDao(): ArtistDao
    abstract fun audioBookDao(): AudioBookDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun playListDao(): PlayListDao
    abstract fun showDao(): ShowDao
    abstract fun trackDao(): TrackDao
}
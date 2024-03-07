package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

@Entity(tableName = "tbl_album")
data class AlbumEntity (
    @PrimaryKey
    @Nonnull
    var id: String,

    var albumType: String? = null,

    var totalTracks: Int? = null,

    var imgUrls: List<String>? = null,

    var name: String? = null,

    var releaseDate: String? = null,

    var releaseDatePrecision: String? = null,

    var type: String? = null,

    var uri: String? = null,

    var artistNames: List<String>? = null
)
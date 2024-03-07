package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

@Entity(tableName = "tbl_artist")
data class ArtistEntity (

    @PrimaryKey
    @Nonnull
    var id: String,

    var totalFollowers: Int? = null,

    var genres: List<String>? = null,

    var imgUrls: List<String>? = null,

    var name: String? = null,

    var popularity: Int? = null,

    var type: String? = null,

    var uri: String? = null,
)
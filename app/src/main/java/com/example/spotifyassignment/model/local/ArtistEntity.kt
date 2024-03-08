package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

/**
 * Represents an entity for storing artist information.
 *
 * @param id The unique identifier of the artist.
 * @param totalFollowers The total number of followers of the artist.
 * @param genres The genres associated with the artist.
 * @param imgUrls The URLs of images associated with the artist.
 * @param name The name of the artist.
 * @param popularity The popularity of the artist.
 * @param type The type of the artist.
 * @param uri The URI of the artist.
 */
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
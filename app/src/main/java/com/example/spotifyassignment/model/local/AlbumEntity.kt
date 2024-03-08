package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

/**
 * Represents an entity for storing album information.
 *
 * @param id The unique identifier of the album.
 * @param albumType The type of the album.
 * @param totalTracks The total number of tracks in the album.
 * @param imgUrls The URLs of images associated with the album.
 * @param name The name of the album.
 * @param releaseDate The release date of the album.
 * @param releaseDatePrecision The precision of the release date.
 * @param type The type of the album.
 * @param uri The URI of the album.
 * @param artistNames The names of the artists associated with the album.
 */
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
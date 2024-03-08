package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

/**
 * Represents an entity for storing playlist information.
 *
 * @param id The unique identifier of the playlist.
 * @param collaborative Whether the playlist is collaborative.
 * @param description The description of the playlist.
 * @param imgUrls The URLs of images associated with the playlist.
 * @param name The name of the playlist.
 * @param ownerName The name of the owner of the playlist.
 * @param public Whether the playlist is public.
 * @param totalTracks The total number of tracks in the playlist.
 * @param type The type of the playlist.
 * @param uri The URI of the playlist.
 */
@Entity(tableName = "tbl_playlist")
data class PlayListEntity (

    @PrimaryKey
    @Nonnull
    var id: String,

    var collaborative: Boolean? = null,

    var description: String? = null,

    var imgUrls: List<String>? = null,

    var name: String? = null,

    var ownerName: String? = null,

    var public: Boolean? = null,

    var totalTracks: Int? = null,

    var type: String? = null,

    var uri: String? = null
)
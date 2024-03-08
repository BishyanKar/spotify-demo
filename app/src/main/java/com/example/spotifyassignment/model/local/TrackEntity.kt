package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Nonnull

/**
 * Represents an entity for storing track information.
 *
 * @param id The unique identifier of the track.
 * @param albumName The name of the album containing the track.
 * @param artistNames The names of the artists associated with the track.
 * @param discNumber The disc number of the track.
 * @param durationMs The duration of the track in milliseconds.
 * @param explicit Whether the track contains explicit content.
 * @param isPlayable Whether the track is playable.
 * @param name The name of the track.
 * @param popularity The popularity of the track.
 * @param previewUrl The URL for previewing the track.
 * @param trackNumber The track number of the track.
 * @param type The type of the track.
 * @param uri The URI of the track.
 * @param isLocal Whether the track is local.
 */
@Entity(tableName = "tbl_track")
data class TrackEntity (

    @PrimaryKey
    @Nonnull
    var id: String,

    var albumName: String? = null,

    var artistNames: List<String>? = null,

    var discNumber: Int? = null,

    var durationMs: Int? = null,

    var explicit: Boolean? = null,

    var isPlayable: Boolean? = null,

    var name: String? = null,

    var popularity: Int? = null,

    var previewUrl: String? = null,

    var trackNumber: Int? = null,

    var type: String? = null,

    var uri: String? = null,

    var isLocal: Boolean? = null
)


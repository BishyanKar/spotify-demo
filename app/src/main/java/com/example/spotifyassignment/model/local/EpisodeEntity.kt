package com.example.spotifyassignment.model.local


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Nonnull

/**
 * Represents an entity for storing episode information.
 *
 * @param id The unique identifier of the episode.
 * @param description The description of the episode.
 * @param durationMs The duration of the episode in milliseconds.
 * @param explicit Whether the episode contains explicit content.
 * @param imgUrls The URLs of images associated with the episode.
 * @param isPlayable Whether the episode is playable.
 * @param language The language of the episode.
 * @param name The name of the episode.
 * @param releaseDate The release date of the episode.
 * @param releaseDatePrecision The precision of the release date.
 * @param type The type of the episode.
 * @param uri The URI of the episode.
 */
@Entity(tableName = "tbl_episode")
data class EpisodeEntity (

    @PrimaryKey
    @Nonnull
    var id: String,

    var description: String? = null,

    var durationMs: Int? = null,

    var explicit: Boolean? = null,

    var imgUrls: List<String>? = null,

    var isPlayable: Boolean? = null,

    var language: String? = null,

    var name: String? = null,

    var releaseDate: String? = null,

    var releaseDatePrecision: String? = null,

    var type: String? = null,

    var uri: String? = null
)


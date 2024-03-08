package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Nonnull

/**
 * Represents an entity for storing show information.
 *
 * @param id The unique identifier of the show.
 * @param description The description of the show.
 * @param explicit Whether the show contains explicit content.
 * @param imgUrls The URLs of images associated with the show.
 * @param mediaType The media type of the show.
 * @param name The name of the show.
 * @param publisher The publisher of the show.
 * @param type The type of the show.
 * @param uri The URI of the show.
 * @param totalEpisodes The total number of episodes in the show.
 */
@Entity(tableName = "tbl_show")
data class ShowEntity (

    @PrimaryKey
    @Nonnull
    var id: String,

    var description: String? = null,

    var explicit: Boolean? = null,

    var imgUrls: List<String>? = null,

    var mediaType: String? = null,

    var name: String? = null,

    var publisher: String? = null,

    var type: String? = null,

    var uri: String? = null,

    var totalEpisodes: Int? = null
)


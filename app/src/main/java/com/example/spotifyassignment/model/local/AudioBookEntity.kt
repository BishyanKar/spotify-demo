package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

/**
 * Represents an entity for storing audiobook information.
 *
 * @param id The unique identifier of the audiobook.
 * @param authors The authors of the audiobook.
 * @param description The description of the audiobook.
 * @param edition The edition of the audiobook.
 * @param explicit Whether the audiobook contains explicit content.
 * @param imgUrls The URLs of images associated with the audiobook.
 * @param mediaType The media type of the audiobook.
 * @param name The name of the audiobook.
 * @param narrators The narrators of the audiobook.
 * @param publisher The publisher of the audiobook.
 * @param type The type of the audiobook.
 * @param uri The URI of the audiobook.
 * @param totalChapters The total number of chapters in the audiobook.
 */
@Entity(tableName = "tbl_audio_book")
data class AudioBookEntity (

    @PrimaryKey
    @Nonnull
    var id: String,

    var authors: List<String>? = null,

    var description: String? = null,

    var edition: String? = null,

    var explicit: Boolean? = null,

    var imgUrls: List<String>? = null,

    var mediaType: String? = null,

    var name: String? = null,

    var narrators: List<String>? = null,

    var publisher: String? = null,

    var type: String? = null,

    var uri: String? = null,

    var totalChapters: Int? = null
)


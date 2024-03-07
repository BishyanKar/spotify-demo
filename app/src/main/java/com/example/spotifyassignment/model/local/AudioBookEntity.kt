package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_audio_book")
data class AudioBookEntity (

    @PrimaryKey
    var id: String? = null,

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


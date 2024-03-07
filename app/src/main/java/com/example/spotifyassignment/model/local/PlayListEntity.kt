package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_playlist")
data class PlayListEntity (

    @PrimaryKey
    var id: String? = null,

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
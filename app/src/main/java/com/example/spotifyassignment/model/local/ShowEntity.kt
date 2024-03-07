package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "tbl_show")
data class ShowEntity (

    @PrimaryKey
    var id: String? = null,

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


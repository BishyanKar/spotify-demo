package com.example.spotifyassignment.model.local


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tbl_episode")
data class EpisodeEntity (

    @PrimaryKey
    var id: String? = null,

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


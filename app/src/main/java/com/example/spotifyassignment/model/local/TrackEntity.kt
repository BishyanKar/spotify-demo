package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Nonnull


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


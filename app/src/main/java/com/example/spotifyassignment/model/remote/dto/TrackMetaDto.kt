package com.example.spotifyassignment.model.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TrackMetaDto {
    @SerializedName("href")
    @Expose
    var href: String? = null

    @SerializedName("total")
    @Expose
    var total: Int? = null
}
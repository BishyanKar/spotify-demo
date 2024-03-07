package com.example.spotifyassignment.model.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ImageDto {
    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("height")
    @Expose
    var height: Int? = null

    @SerializedName("width")
    @Expose
    var width: Int? = null
}
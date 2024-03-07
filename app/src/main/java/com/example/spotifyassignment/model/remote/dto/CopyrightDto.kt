package com.example.spotifyassignment.model.remote.dto

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class CopyrightDto {
    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null
}
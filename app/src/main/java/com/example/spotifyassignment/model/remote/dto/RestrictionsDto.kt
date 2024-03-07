package com.example.spotifyassignment.model.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RestrictionsDto {
    @SerializedName("reason")
    @Expose
    var reason: String? = null
}
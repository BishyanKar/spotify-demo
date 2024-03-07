package com.example.spotifyassignment.model.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ErrorResponse {
    @SerializedName("status")
    @Expose
    var status: Int? = null

    @SerializedName("message")
    @Expose
    var message: String? = null
}
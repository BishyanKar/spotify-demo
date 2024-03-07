package com.example.spotifyassignment.model.remote

import com.example.spotifyassignment.model.remote.dto.AudioBookDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AudioBookResponse: BaseResponse() {
    @SerializedName("items")
    @Expose
    var artists: List<AudioBookDto>? = null
}
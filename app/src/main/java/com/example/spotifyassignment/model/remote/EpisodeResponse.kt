package com.example.spotifyassignment.model.remote

import com.example.spotifyassignment.model.remote.dto.EpisodeDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EpisodeResponse: BaseResponse() {
    @SerializedName("items")
    @Expose
    var artists: List<EpisodeDto>? = null
}
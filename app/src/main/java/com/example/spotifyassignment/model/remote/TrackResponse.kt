package com.example.spotifyassignment.model.remote

import com.example.spotifyassignment.model.remote.dto.TrackDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TrackResponse: BaseResponse() {
    @SerializedName("items")
    @Expose
    var tracks: List<TrackDto>? = null
}
package com.example.spotifyassignment.model.remote

import com.example.spotifyassignment.model.remote.dto.ArtistDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ArtistResponse: BaseResponse() {
    @SerializedName("items")
    @Expose
    var artists: List<ArtistDto>? = null
}
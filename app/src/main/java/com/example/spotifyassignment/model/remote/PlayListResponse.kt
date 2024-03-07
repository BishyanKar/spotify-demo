package com.example.spotifyassignment.model.remote

import com.example.spotifyassignment.model.remote.dto.PlayListDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlayListResponse: BaseResponse() {
    @SerializedName("items")
    @Expose
    var artists: List<PlayListDto>? = null
}
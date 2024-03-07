package com.example.spotifyassignment.model.remote

import com.example.spotifyassignment.model.remote.dto.ShowDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ShowResponse: BaseResponse() {
    @SerializedName("items")
    @Expose
    var items: List<ShowDto> = ArrayList()
}
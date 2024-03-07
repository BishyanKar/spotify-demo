package com.example.spotifyassignment.model.remote

import com.example.spotifyassignment.model.remote.dto.AlbumDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AlbumResponse {
    @SerializedName("items")
    @Expose
    var items: List<AlbumDto> = ArrayList()
}
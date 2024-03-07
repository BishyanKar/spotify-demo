package com.example.spotifyassignment.model.remote.dto

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class NarratorDto {
    @SerializedName("name")
    @Expose
    var name: String? = null
}
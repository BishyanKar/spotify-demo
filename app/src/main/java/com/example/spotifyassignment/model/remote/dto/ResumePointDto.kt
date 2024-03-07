package com.example.spotifyassignment.model.remote.dto

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class ResumePointDto {
    @SerializedName("fully_played")
    @Expose
    var fullyPlayed: Boolean? = null

    @SerializedName("resume_position_ms")
    @Expose
    var resumePositionMs: Int? = null
}
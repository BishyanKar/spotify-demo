package com.example.spotifyassignment.model.remote.dto


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class EpisodeDto {
    @SerializedName("audio_preview_url")
    @Expose
    var audioPreviewUrl: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("html_description")
    @Expose
    var htmlDescription: String? = null

    @SerializedName("duration_ms")
    @Expose
    var durationMs: Int? = null

    @SerializedName("explicit")
    @Expose
    var explicit: Boolean? = null

    @SerializedName("href")
    @Expose
    var episodeDetailsLink: String? = null

    @SerializedName("id")
    @Expose
    var id: String = ""

    @SerializedName("images")
    @Expose
    var images: List<ImageDto>? = null

    @SerializedName("is_externally_hosted")
    @Expose
    var isExternallyHosted: Boolean? = null

    @SerializedName("is_playable")
    @Expose
    var isPlayable: Boolean? = null

    @SerializedName("language")
    @Expose
    var language: String? = null

    @SerializedName("languages")
    @Expose
    var languages: List<String>? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = null

    @SerializedName("release_date_precision")
    @Expose
    var releaseDatePrecision: String? = null

    @SerializedName("resume_point")
    @Expose
    var resumePoint: ResumePointDto? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("uri")
    @Expose
    var uri: String? = null

    @SerializedName("restrictions")
    @Expose
    var restrictions: RestrictionsDto? = null
}


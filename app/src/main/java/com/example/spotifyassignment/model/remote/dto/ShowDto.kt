package com.example.spotifyassignment.model.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ShowDto {
    @SerializedName("available_markets")
    @Expose
    var availableMarkets: List<String>? = null

    @SerializedName("copyrights")
    @Expose
    var copyrights: List<CopyrightDto>? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("html_description")
    @Expose
    var htmlDescription: String? = null

    @SerializedName("explicit")
    @Expose
    var explicit: Boolean? = null

    @SerializedName("href")
    @Expose
    var showDetailsLink: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("images")
    @Expose
    var images: List<ImageDto>? = null

    @SerializedName("is_externally_hosted")
    @Expose
    var isExternallyHosted: Boolean? = null

    @SerializedName("languages")
    @Expose
    var languages: List<String>? = null

    @SerializedName("media_type")
    @Expose
    var mediaType: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("publisher")
    @Expose
    var publisher: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("uri")
    @Expose
    var uri: String? = null

    @SerializedName("total_episodes")
    @Expose
    var totalEpisodes: Int? = null
}


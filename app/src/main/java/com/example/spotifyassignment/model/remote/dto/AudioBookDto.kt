package com.example.spotifyassignment.model.remote.dto


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class AudioBookDto {
    @SerializedName("authors")
    @Expose
    var authors: List<AuthorDto>? = null

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

    @SerializedName("edition")
    @Expose
    var edition: String? = null

    @SerializedName("explicit")
    @Expose
    var explicit: Boolean? = null

    @SerializedName("href")
    @Expose
    var audioBookDetailsLink: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("images")
    @Expose
    var images: List<ImageDto>? = null

    @SerializedName("languages")
    @Expose
    var languages: List<String>? = null

    @SerializedName("media_type")
    @Expose
    var mediaType: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("narrators")
    @Expose
    var narrators: List<NarratorDto>? = null

    @SerializedName("publisher")
    @Expose
    var publisher: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("uri")
    @Expose
    var uri: String? = null

    @SerializedName("total_chapters")
    @Expose
    var totalChapters: Int? = null
}


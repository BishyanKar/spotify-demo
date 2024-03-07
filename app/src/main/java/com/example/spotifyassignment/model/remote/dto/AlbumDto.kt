package com.example.spotifyassignment.model.remote.dto


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class AlbumDto {
    @SerializedName("album_type")
    @Expose
    var albumType: String? = null

    @SerializedName("total_tracks")
    @Expose
    var totalTracks: Int? = null

    @SerializedName("available_markets")
    @Expose
    var availableMarkets: List<String>? = null

    @SerializedName("href")
    @Expose
    var albumDetailsLink: String? = null

    @SerializedName("id")
    @Expose
    var id: String = ""

    @SerializedName("images")
    @Expose
    var images: List<ImageDto>? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = null

    @SerializedName("release_date_precision")
    @Expose
    var releaseDatePrecision: String? = null

    @SerializedName("restrictions")
    @Expose
    var restrictions: RestrictionsDto? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("uri")
    @Expose
    var uri: String? = null

    @SerializedName("artists")
    @Expose
    var artists: List<ArtistDto>? = null
}
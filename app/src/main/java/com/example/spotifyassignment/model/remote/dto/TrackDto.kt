package com.example.spotifyassignment.model.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class TrackDto {
    @SerializedName("album")
    @Expose
    var album: AlbumDto? = null

    @SerializedName("artists")
    @Expose
    var artists: List<ArtistDto>? = null

    @SerializedName("available_markets")
    @Expose
    var availableMarkets: List<String>? = null

    @SerializedName("disc_number")
    @Expose
    var discNumber: Int? = null

    @SerializedName("duration_ms")
    @Expose
    var durationMs: Int? = null

    @SerializedName("explicit")
    @Expose
    var explicit: Boolean? = null

    @SerializedName("href")
    @Expose
    var trackDetailsLink: String? = null

    @SerializedName("id")
    @Expose
    var id: String = ""

    @SerializedName("is_playable")
    @Expose
    var isPlayable: Boolean? = null

    @SerializedName("restrictions")
    @Expose
    var restrictions: RestrictionsDto? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("popularity")
    @Expose
    var popularity: Int? = null

    @SerializedName("preview_url")
    @Expose
    var previewUrl: String? = null

    @SerializedName("track_number")
    @Expose
    var trackNumber: Int? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("uri")
    @Expose
    var uri: String? = null

    @SerializedName("is_local")
    @Expose
    var isLocal: Boolean? = null
}


package com.example.spotifyassignment.model.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchResponse {
    @SerializedName("tracks")
    @Expose
    var trackResponse: TrackResponse? = null

    @SerializedName("artists")
    @Expose
    var artistResponse: ArtistResponse? = null

    @SerializedName("albums")
    @Expose
    var albumResponse: AlbumResponse? = null

    @SerializedName("playlists")
    @Expose
    var playListResponse: PlayListResponse? = null

    @SerializedName("shows")
    @Expose
    var showResponse: ShowResponse? = null

    @SerializedName("episodes")
    @Expose
    var episodeResponse: EpisodeResponse? = null

    @SerializedName("audiobooks")
    @Expose
    var audioBookResponse: AudioBookResponse? = null

    @SerializedName("error")
    @Expose
    var errorResponse: ErrorResponse? = null
}
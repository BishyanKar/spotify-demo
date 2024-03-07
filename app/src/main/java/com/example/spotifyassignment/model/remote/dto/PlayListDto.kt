package com.example.spotifyassignment.model.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class PlayListDto {
    @SerializedName("collaborative")
    @Expose
    var collaborative: Boolean? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("href")
    @Expose
    var href: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("images")
    @Expose
    var images: List<ImageDto>? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("owner")
    @Expose
    var owner: OwnerDto? = null

    @SerializedName("public")
    @Expose
    var public: Boolean? = null

    @SerializedName("snapshot_id")
    @Expose
    var snapshotId: String? = null

    @SerializedName("tracks")
    @Expose
    var tracks: TrackMetaDto? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("uri")
    @Expose
    var uri: String? = null
}
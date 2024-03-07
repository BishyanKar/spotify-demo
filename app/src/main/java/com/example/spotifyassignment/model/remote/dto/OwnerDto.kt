package com.example.spotifyassignment.model.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class OwnerDto {
    @SerializedName("followers")
    @Expose
    var followers: FollowersDto? = null

    @SerializedName("href")
    @Expose
    var href: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("uri")
    @Expose
    var uri: String? = null

    @SerializedName("display_name")
    @Expose
    var displayName: String? = null
}
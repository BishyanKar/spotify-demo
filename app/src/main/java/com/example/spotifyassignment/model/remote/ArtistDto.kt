package com.example.spotifyassignment.model.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ArtistDto {
    @SerializedName("followers")
    @Expose
    var followersDto: FollowersDto? = null

    @SerializedName("genres")
    @Expose
    var genres: List<String>? = null

    @SerializedName("href")
    @Expose
    var artistDetailLink: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("images")
    @Expose
    var images: List<ImageDto>? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("popularity")
    @Expose
    var popularity: Int? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("uri")
    @Expose
    var uri: String? = null
}
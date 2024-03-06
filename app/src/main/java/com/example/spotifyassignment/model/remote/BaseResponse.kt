package com.example.spotifyassignment.model.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class BaseResponse {
    @SerializedName("href")
    @Expose
    var href: String? = null

    @SerializedName("limit")
    @Expose
    var limit: Int? = null

    @SerializedName("next")
    @Expose
    var next: String? = null

    @SerializedName("offset")
    @Expose
    var offset: Int? = null

    @SerializedName("previous")
    @Expose
    var previous: String? = null

    @SerializedName("total")
    @Expose
    var total: Int? = null
}
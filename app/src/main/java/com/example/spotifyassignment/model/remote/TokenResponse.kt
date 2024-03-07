package com.example.spotifyassignment.model.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TokenResponse {
    @SerializedName("access_token")
    @Expose
    var accessToken: String? = null

    @SerializedName("token_type")
    @Expose
    var tokenType: String? = null

    @SerializedName("expires_in")
    @Expose
    var expiresIn: Long? = null

    @SerializedName("error")
    @Expose
    var error: String? = null
}
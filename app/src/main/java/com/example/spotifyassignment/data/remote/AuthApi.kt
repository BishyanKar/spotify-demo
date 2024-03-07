package com.example.spotifyassignment.data.remote

import ApiResponse
import androidx.lifecycle.LiveData
import com.example.spotifyassignment.model.remote.TokenResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @POST("token")
    @FormUrlEncoded
    fun authenticate(
        @Field("grant_type") grantType: String,
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String
    ): LiveData<ApiResponse<TokenResponse>>
}
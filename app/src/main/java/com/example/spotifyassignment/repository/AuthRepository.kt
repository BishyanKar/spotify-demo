package com.example.spotifyassignment.repository

import ApiResponse
import androidx.lifecycle.LiveData
import com.example.spotifyassignment.Constants
import com.example.spotifyassignment.data.remote.AuthApi
import com.example.spotifyassignment.model.remote.TokenResponse
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authApi: AuthApi
) {
    fun authenticate(): LiveData<ApiResponse<TokenResponse>> {
        return authApi.authenticate(
            Constants.GRANT_TYPE,
            Constants.CLIENT_ID,
            Constants.CLIENT_SECRET
        )
    }
}
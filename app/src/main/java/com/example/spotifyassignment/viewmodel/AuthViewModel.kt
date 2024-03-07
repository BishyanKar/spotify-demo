package com.example.spotifyassignment.viewmodel

import ApiResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.spotifyassignment.model.remote.TokenResponse
import com.example.spotifyassignment.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {
    fun authenticate(): LiveData<ApiResponse<TokenResponse>> {
        return authRepository.authenticate()
    }
}
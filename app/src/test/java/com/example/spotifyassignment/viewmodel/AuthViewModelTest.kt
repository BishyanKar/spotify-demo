package com.example.spotifyassignment.viewmodel

import ApiResponse
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.spotifyassignment.model.remote.TokenResponse
import com.example.spotifyassignment.repository.AuthRepository
import io.mockk.coEvery
import org.junit.Before
import org.junit.Test
import io.mockk.mockk
import junit.framework.TestCase
import org.junit.Rule
import retrofit2.Response


class AuthViewModelTest {

    private val authRepository = mockk<AuthRepository>(relaxed = true)
    private lateinit var authViewModel: AuthViewModel

    // This rule is used to swap the background executor used by the Architecture Components
    // with a different one which executes each task synchronously.
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val mutableLiveData = MutableLiveData<ApiResponse<TokenResponse>>()
        val tokenResponse = TokenResponse()
        tokenResponse.accessToken = "test"
        mutableLiveData.value = ApiResponse(Response.success(tokenResponse))

        coEvery { authRepository.authenticate() } returns mutableLiveData

        authViewModel = AuthViewModel(authRepository)
    }

    @Test
    fun authenticate() {
        TestCase.assertNotNull(authViewModel.authenticate())
        TestCase.assertEquals("test", authViewModel.authenticate().value?.body?.accessToken)
    }
}
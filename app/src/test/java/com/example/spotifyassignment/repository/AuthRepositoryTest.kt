package com.example.spotifyassignment.repository

import ApiResponse
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.spotifyassignment.data.remote.AuthApi
import com.example.spotifyassignment.model.remote.TokenResponse
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

class AuthRepositoryTest {

    private val authApi = mockk<AuthApi>(relaxed = true)
    private lateinit var authRepo: AuthRepository

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
        coEvery { authApi.authenticate(any(), any(), any()) } returns mutableLiveData

        authRepo = AuthRepository(authApi)
    }

    @Test
    fun authenticate() {
        assertNotNull(authRepo.authenticate())
        assertEquals("test", authRepo.authenticate().value?.body?.accessToken)
    }
}
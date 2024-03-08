package com.example.spotifyassignment.repository

import ApiResponse
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.spotifyassignment.data.remote.MusicApi
import com.example.spotifyassignment.model.remote.AlbumResponse
import com.example.spotifyassignment.model.remote.SearchResponse
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

class SearchRemoteRepositoryTest {

    private val musicApi = mockk<MusicApi>(relaxed = true)
    private lateinit var searchRemoteRepository: SearchRemoteRepository

    // This rule is used to swap the background executor used by the Architecture Components
    // with a different one which executes each task synchronously.
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val mutableLiveData = MutableLiveData<ApiResponse<SearchResponse>>()
        val searchResponse = SearchResponse()
        searchResponse.albumResponse = AlbumResponse()
        mutableLiveData.value = ApiResponse(Response.success(searchResponse))

        coEvery { musicApi.getMusicItems(any(), any()) } returns mutableLiveData

        searchRemoteRepository = SearchRemoteRepository(musicApi)
    }

    @Test
    fun getAllMusicItems() {
        assertNotNull(searchRemoteRepository.getAllMusicItems("", arrayListOf()))
        assertNotNull(searchRemoteRepository.getAllMusicItems("", arrayListOf()).value?.body?.albumResponse)
    }
}
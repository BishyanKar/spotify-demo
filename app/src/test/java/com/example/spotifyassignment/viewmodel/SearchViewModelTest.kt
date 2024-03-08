package com.example.spotifyassignment.viewmodel

import ApiResponse
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.spotifyassignment.model.remote.AlbumResponse
import com.example.spotifyassignment.model.remote.SearchResponse
import com.example.spotifyassignment.repository.SearchLocalRepository
import com.example.spotifyassignment.repository.SearchRemoteRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response


class SearchViewModelTest {

    private val searchRemoteRepository = mockk<SearchRemoteRepository>(relaxed = true)
    private val searchLocalRepository = mockk<SearchLocalRepository>(relaxed = true)
    private lateinit var searchViewModel: SearchViewModel

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

        coEvery { searchRemoteRepository.getAllMusicItems(any(), any()) } returns mutableLiveData

        searchViewModel = SearchViewModel(searchRemoteRepository, searchLocalRepository)
    }

    @Test
    fun searchMusic() {
        assertNotNull(searchViewModel.searchMusic(""))
        assertNotNull(searchViewModel.searchMusic("").value?.body?.albumResponse)
    }
}
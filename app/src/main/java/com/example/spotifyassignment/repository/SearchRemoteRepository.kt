package com.example.spotifyassignment.repository

import ApiResponse
import androidx.lifecycle.LiveData
import com.example.spotifyassignment.data.remote.MusicApi
import com.example.spotifyassignment.model.remote.SearchResponse
import javax.inject.Inject

class SearchRemoteRepository @Inject constructor(
    private val musicApi: MusicApi
) {
    fun getAllMusicItems(query: String, types: List<String>): LiveData<ApiResponse<SearchResponse>> {
        return musicApi.getMusicItems(query, types);
    }
}
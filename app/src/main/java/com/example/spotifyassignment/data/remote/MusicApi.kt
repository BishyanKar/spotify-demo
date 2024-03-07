package com.example.spotifyassignment.data.remote

import ApiResponse
import androidx.lifecycle.LiveData
import com.example.spotifyassignment.model.remote.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicApi {
    @GET("/search")
    fun getMusicItems(
        @Query("q") query: String,
        @Query("type") types: List<String>
    ): LiveData<ApiResponse<SearchResponse>>
}
package com.example.spotifyassignment.repository

import com.example.spotifyassignment.data.local.dao.AlbumDao
import com.example.spotifyassignment.data.local.dao.ArtistDao
import com.example.spotifyassignment.data.local.dao.AudioBookDao
import com.example.spotifyassignment.data.local.dao.EpisodeDao
import com.example.spotifyassignment.data.local.dao.PlayListDao
import com.example.spotifyassignment.data.local.dao.ShowDao
import com.example.spotifyassignment.data.local.dao.TrackDao
import com.example.spotifyassignment.data.remote.AuthApi
import com.example.spotifyassignment.data.remote.MusicApi
import javax.inject.Inject

class SearchRemoteRepository @Inject constructor(
    private val musicApi: MusicApi,
    private val authApi: AuthApi
) {
}
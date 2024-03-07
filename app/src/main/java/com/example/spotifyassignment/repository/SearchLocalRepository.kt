package com.example.spotifyassignment.repository

import com.example.spotifyassignment.data.local.dao.AlbumDao
import com.example.spotifyassignment.data.local.dao.ArtistDao
import com.example.spotifyassignment.data.local.dao.AudioBookDao
import com.example.spotifyassignment.data.local.dao.EpisodeDao
import com.example.spotifyassignment.data.local.dao.PlayListDao
import com.example.spotifyassignment.data.local.dao.ShowDao
import com.example.spotifyassignment.data.local.dao.TrackDao
import javax.inject.Inject

class SearchLocalRepository @Inject constructor(
    private val albumDao: AlbumDao,
    private val artistDao: ArtistDao,
    private val audioBookDao: AudioBookDao,
    private val episodeDao: EpisodeDao,
    private val playListDao: PlayListDao,
    private val showDao: ShowDao,
    private val trackDao: TrackDao
) {
}
package com.example.spotifyassignment.repository

import com.example.spotifyassignment.data.local.dao.AlbumDao
import com.example.spotifyassignment.data.local.dao.ArtistDao
import com.example.spotifyassignment.data.local.dao.AudioBookDao
import com.example.spotifyassignment.data.local.dao.EpisodeDao
import com.example.spotifyassignment.data.local.dao.PlayListDao
import com.example.spotifyassignment.data.local.dao.ShowDao
import com.example.spotifyassignment.data.local.dao.TrackDao
import com.example.spotifyassignment.model.local.AlbumEntity
import com.example.spotifyassignment.model.local.ArtistEntity
import com.example.spotifyassignment.model.local.AudioBookEntity
import com.example.spotifyassignment.model.local.EpisodeEntity
import com.example.spotifyassignment.model.local.PlayListEntity
import com.example.spotifyassignment.model.local.ShowEntity
import com.example.spotifyassignment.model.local.TrackEntity
import kotlinx.coroutines.flow.Flow
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
    val allAlbums: Flow<List<AlbumEntity>> = albumDao.getAllAlbums()
    val allArtists: Flow<List<ArtistEntity>> = artistDao.getAllArtists()
    val allAudioBooks: Flow<List<AudioBookEntity>> = audioBookDao.getAllAudioBooks()
    val allEpisodes: Flow<List<EpisodeEntity>> = episodeDao.getAllEpisodes()
    val allPlayLists: Flow<List<PlayListEntity>> = playListDao.getAllPlayLists()
    val allShows: Flow<List<ShowEntity>> = showDao.getAllShows()
    val allTracks: Flow<List<TrackEntity>> = trackDao.getAllTracks()

    fun getAlbumById(id: String): Flow<AlbumEntity> {
        return albumDao.getAlbumById(id)
    }

    fun getArtistById(id: String): Flow<ArtistEntity> {
        return artistDao.getArtistById(id)
    }

    fun getAudioBookById(id: String): Flow<AudioBookEntity> {
        return audioBookDao.getAudioBookById(id)
    }

    fun getEpisodeById(id: String): Flow<EpisodeEntity> {
        return episodeDao.getEpisodeById(id)
    }

    fun getPlayListById(id: String): Flow<PlayListEntity> {
        return playListDao.getPlayListById(id)
    }

    fun getShowById(id: String): Flow<ShowEntity> {
        return showDao.getShowById(id)
    }

    fun getTrackById(id: String): Flow<TrackEntity> {
        return trackDao.getTrackById(id)
    }

    suspend fun insertAllAlbums(albumEntities: List<AlbumEntity>) {
        albumDao.insertAll(albumEntities)
    }

    suspend fun insertAllArtists(artistEntities: List<ArtistEntity>) {
        artistDao.insertAll(artistEntities)
    }

    suspend fun insertAllAudioBooks(audioBookEntities: List<AudioBookEntity>) {
        audioBookDao.insertAll(audioBookEntities)
    }

    suspend fun insertAllEpisodes(episodeEntities: List<EpisodeEntity>) {
        episodeDao.insertAll(episodeEntities)
    }

    suspend fun insertAllPlayLists(playListEntities: List<PlayListEntity>) {
        playListDao.insertAll(playListEntities)
    }

    suspend fun insertAllShows(showEntities: List<ShowEntity>) {
        showDao.insertAll(showEntities)
    }

    suspend fun insertAllTracks(trackEntities: List<TrackEntity>) {
        trackDao.insertAll(trackEntities)
    }

    suspend fun deleteAll() {
        albumDao.deleteAll()
        artistDao.deleteAll()
        audioBookDao.deleteAll()
        playListDao.deleteAll()
        episodeDao.deleteAll()
        showDao.deleteAll()
        trackDao.deleteAll()
    }
}
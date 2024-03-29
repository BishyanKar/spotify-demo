package com.example.spotifyassignment.viewmodel

import ApiResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.spotifyassignment.model.local.AlbumEntity
import com.example.spotifyassignment.model.local.ArtistEntity
import com.example.spotifyassignment.model.local.AudioBookEntity
import com.example.spotifyassignment.model.local.EpisodeEntity
import com.example.spotifyassignment.model.local.PlayListEntity
import com.example.spotifyassignment.model.local.ShowEntity
import com.example.spotifyassignment.model.local.TrackEntity
import com.example.spotifyassignment.model.remote.AlbumResponse
import com.example.spotifyassignment.model.remote.ArtistResponse
import com.example.spotifyassignment.model.remote.AudioBookResponse
import com.example.spotifyassignment.model.remote.EpisodeResponse
import com.example.spotifyassignment.model.remote.PlayListResponse
import com.example.spotifyassignment.model.remote.SearchResponse
import com.example.spotifyassignment.model.remote.ShowResponse
import com.example.spotifyassignment.model.remote.TrackResponse
import com.example.spotifyassignment.repository.SearchLocalRepository
import com.example.spotifyassignment.repository.SearchRemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.stream.Collectors
import javax.inject.Inject

/**
 * ViewModel responsible for managing search-related data and operations.
 *
 * @param searchRemoteRepository Repository for fetching search results from remote data source.
 * @param searchLocalRepository Repository for accessing and modifying search results stored locally.
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRemoteRepository: SearchRemoteRepository,
    private val searchLocalRepository: SearchLocalRepository
): ViewModel() {

    // LiveData for observing cached lists of various music items
    val tracks: LiveData<List<TrackEntity>> = searchLocalRepository.allTracks.asLiveData()
    val albums: LiveData<List<AlbumEntity>> = searchLocalRepository.allAlbums.asLiveData()
    val artists: LiveData<List<ArtistEntity>> = searchLocalRepository.allArtists.asLiveData()
    val audioBooks: LiveData<List<AudioBookEntity>> = searchLocalRepository.allAudioBooks.asLiveData()
    val episodes: LiveData<List<EpisodeEntity>> = searchLocalRepository.allEpisodes.asLiveData()
    val playLists: LiveData<List<PlayListEntity>> = searchLocalRepository.allPlayLists.asLiveData()
    val shows: LiveData<List<ShowEntity>> = searchLocalRepository.allShows.asLiveData()

    // List of search types and their corresponding tabs
    private val searchTypes = arrayListOf("album", "artist", "playlist", "track", "show", "episode", "audiobook")
    final val searchTabs = arrayListOf("Album", "Artist", "Playlist", "Track", "Show", "Episode", "AudioBook")

    /**
     * Searches for music items based on the provided query.
     *
     * @param query The search query.
     * @return LiveData representing the ApiResponse containing search results.
     */
    fun searchMusic(query: String): LiveData<ApiResponse<SearchResponse>> {
        return searchRemoteRepository.getAllMusicItems(
            query,
            searchTypes
        )
    }

    /**
     * Updates the cache with the provided search response.
     *
     * @param searchResponse The search response containing updated data.
     */
    fun updateCache(searchResponse: SearchResponse) {
        //assumed to be error free response, the check should happen in UI
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllCache()
            updateAlbumCache(searchResponse.albumResponse ?: AlbumResponse())
            updateArtistCache(searchResponse.artistResponse ?: ArtistResponse())
            updateEpisodeCache(searchResponse.episodeResponse ?: EpisodeResponse())
            updateAudioBookCache(searchResponse.audioBookResponse ?: AudioBookResponse())
            updateShowCache(searchResponse.showResponse ?: ShowResponse())
            updatePlayListCache(searchResponse.playListResponse ?: PlayListResponse())
            updateTrackCache(searchResponse.trackResponse ?: TrackResponse())
        }
    }

    /**
     * Deletes all cached music items.
     */
    fun deleteAllCache() {
        viewModelScope.launch(Dispatchers.IO) {
            searchLocalRepository.deleteAll()
        }
    }

    // Functions to update cache with specific types of music items

    suspend fun updateAlbumCache(albumResponse: AlbumResponse) {
        searchLocalRepository.insertAllAlbums(
            getAlbumEntitiesFromResponse(albumResponse)
        )
    }

    suspend fun updateArtistCache(artistResponse: ArtistResponse) {
        searchLocalRepository.insertAllArtists(
            getArtistEntitiesFromResponse(artistResponse)
        )
    }

    suspend fun updateAudioBookCache(audioBookResponse: AudioBookResponse) {
        searchLocalRepository.insertAllAudioBooks(
            getAudioBookEntitiesFromResponse(audioBookResponse)
        )
    }

    suspend fun updateEpisodeCache(episodeResponse: EpisodeResponse) {
        searchLocalRepository.insertAllEpisodes(
            getEpisodeEntitiesFromResponse(episodeResponse)
        )
    }

    suspend fun updatePlayListCache(playListResponse: PlayListResponse) {
        searchLocalRepository.insertAllPlayLists(
            getPlayListEntitiesFromResponse(playListResponse)
        )
    }

    suspend fun updateShowCache(showResponse: ShowResponse) {
        searchLocalRepository.insertAllShows(
            getShowEntitiesFromResponse(showResponse)
        )
    }

    suspend fun updateTrackCache(trackResponse: TrackResponse) {
        searchLocalRepository.insertAllTracks(
            getTrackEntitiesFromResponse(trackResponse)
        )
    }

    // Functions to convert DTOs to entities

    fun getAlbumEntitiesFromResponse(albumResponse: AlbumResponse): List<AlbumEntity> {
        try {
            return albumResponse.items?.stream()?.map { albumDto ->
                AlbumEntity(
                    albumDto.id,
                    albumDto.albumType,
                    albumDto.totalTracks,
                    albumDto.images?.stream()?.map {imageDto ->
                        imageDto.url ?: ""
                    }?.collect(Collectors.toList()) ?: ArrayList(),
                    albumDto.name,
                    albumDto.releaseDate,
                    albumDto.releaseDatePrecision,
                    albumDto.type,
                    albumDto.uri,
                    albumDto.artists?.stream()?.map {artistDto ->
                        artistDto.name ?: ""
                    }?.collect(Collectors.toList()) ?: ArrayList()
                )
            }?.collect(Collectors.toList()) ?: ArrayList()
        } catch (e: Exception) {
            Timber.e("Error", e)
            return ArrayList()
        }

    }

    fun getArtistEntitiesFromResponse(artistResponse: ArtistResponse): List<ArtistEntity> {
        try {
            return artistResponse.items?.stream()?.map { artistDto ->
                ArtistEntity(
                    artistDto.id,
                    artistDto.followersDto?.total ?: 0,
                    artistDto.genres,
                    artistDto.images?.stream()?.map {imageDto ->
                        imageDto.url ?: ""
                    }?.collect(Collectors.toList()) ?: ArrayList(),
                    artistDto.name,
                    artistDto.popularity,
                    artistDto.type,
                    artistDto.uri
                )
            }?.collect(Collectors.toList()) ?: ArrayList()
        } catch (e: Exception) {
            Timber.e("Error", e)
            return ArrayList()
        }
    }

    fun getAudioBookEntitiesFromResponse(audioBookResponse: AudioBookResponse): List<AudioBookEntity> {
        try {
            return audioBookResponse.items?.stream()?.map { audioBookDto ->
                AudioBookEntity(
                    audioBookDto.id,
                    audioBookDto.authors?.stream()?.map {authorDto ->
                        authorDto.name ?: ""
                    }?.collect(Collectors.toList()) ?: ArrayList(),
                    audioBookDto.description,
                    audioBookDto.edition,
                    audioBookDto.explicit,
                    audioBookDto.images?.stream()?.map {imageDto ->
                        imageDto.url ?: ""
                    }?.collect(Collectors.toList()) ?: ArrayList(),
                    audioBookDto.mediaType,
                    audioBookDto.name,
                    audioBookDto.narrators?.stream()?.map {narratorDto->
                        narratorDto.name ?: ""
                    }?.collect(Collectors.toList()) ?: ArrayList(),
                    audioBookDto.publisher,
                    audioBookDto.type,
                    audioBookDto.uri
                )
            }?.collect(Collectors.toList()) ?: ArrayList()
        } catch (e: Exception) {
            Timber.e("Error", e)
            return ArrayList()
        }
    }

    fun getEpisodeEntitiesFromResponse(episodeResponse: EpisodeResponse): List<EpisodeEntity> {
        try {
            return episodeResponse.items?.stream()?.map { episodeDto ->
                EpisodeEntity(
                    episodeDto.id,
                    episodeDto.description,
                    episodeDto.durationMs,
                    episodeDto.explicit,
                    episodeDto.images?.stream()?.map {imageDto ->
                        imageDto.url ?: ""
                    }?.collect(Collectors.toList()) ?: ArrayList(),
                    episodeDto.isPlayable,
                    episodeDto.language,
                    episodeDto.name,
                    episodeDto.releaseDate,
                    episodeDto.releaseDatePrecision,
                    episodeDto.type,
                    episodeDto.uri
                )
            }?.collect(Collectors.toList()) ?: ArrayList()
        } catch (e: Exception) {
            Timber.e("Error", e)
            return ArrayList()
        }
    }

    fun getPlayListEntitiesFromResponse(playListResponse: PlayListResponse): List<PlayListEntity> {
        try {
            return playListResponse.items?.stream()?.map { playListDto ->
                PlayListEntity(
                    playListDto.id,
                    playListDto.collaborative,
                    playListDto.description,
                    playListDto.images?.stream()?.map {imageDto ->
                        imageDto.url ?: ""
                    }?.collect(Collectors.toList()) ?: ArrayList(),
                    playListDto.name,
                    playListDto.owner?.displayName ?: "",
                    playListDto.public,
                    playListDto.tracks?.total ?: 0,
                    playListDto.type,
                    playListDto.uri
                )
            }?.collect(Collectors.toList()) ?: ArrayList()
        } catch (e: Exception) {
            Timber.e("Error", e)
            return ArrayList()
        }
    }

    fun getShowEntitiesFromResponse(showResponse: ShowResponse): List<ShowEntity> {
        try {
            return showResponse.items?.stream()?.map { showDto ->
                ShowEntity(
                    showDto.id,
                    showDto.description,
                    showDto.explicit,
                    showDto.images?.stream()?.map {imageDto ->
                        imageDto.url ?: ""
                    }?.collect(Collectors.toList()) ?: ArrayList(),
                    showDto.mediaType,
                    showDto.name,
                    showDto.publisher,
                    showDto.type,
                    showDto.uri,
                    showDto.totalEpisodes
                )
            }?.collect(Collectors.toList()) ?: ArrayList()
        } catch (e: Exception) {
            Timber.e("Error", e)
            return ArrayList()
        }
    }

    fun getTrackEntitiesFromResponse(trackResponse: TrackResponse): List<TrackEntity> {
        try {
            return trackResponse.items?.stream()?.map { trackDto ->
                TrackEntity(
                    trackDto.id,
                    trackDto.album?.name ?: "",
                    trackDto.artists?.stream()?.map {artistDto ->
                        artistDto.name ?: ""
                    }?.collect(Collectors.toList()) ?: ArrayList(),
                    trackDto.discNumber,
                    trackDto.durationMs,
                    trackDto.explicit,
                    trackDto.isPlayable,
                    trackDto.name,
                    trackDto.popularity,
                    trackDto.previewUrl,
                    trackDto.trackNumber,
                    trackDto.type,
                    trackDto.uri,
                    trackDto.isLocal
                )
            }?.collect(Collectors.toList()) ?: ArrayList()
        } catch (e: Exception) {
            Timber.e("Error", e)
            return ArrayList()
        }
    }
}
package com.example.spotifyassignment.di

import LiveDataCallAdapterFactory
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.spotifyassignment.Constants
import com.example.spotifyassignment.R
import com.example.spotifyassignment.data.local.MusicDB
import com.example.spotifyassignment.data.local.dao.AlbumDao
import com.example.spotifyassignment.data.local.dao.ArtistDao
import com.example.spotifyassignment.data.local.dao.AudioBookDao
import com.example.spotifyassignment.data.local.dao.EpisodeDao
import com.example.spotifyassignment.data.local.dao.PlayListDao
import com.example.spotifyassignment.data.local.dao.ShowDao
import com.example.spotifyassignment.data.local.dao.TrackDao
import com.example.spotifyassignment.data.remote.AuthApi
import com.example.spotifyassignment.data.remote.AuthInterceptor
import com.example.spotifyassignment.data.remote.MusicApi
import com.example.spotifyassignment.repository.AuthRepository
import com.example.spotifyassignment.repository.SearchLocalRepository
import com.example.spotifyassignment.repository.SearchRemoteRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CoreModule {
    @Provides
    @Singleton
    fun provideMusicDb(@ApplicationContext appContext: Context): MusicDB {
        return Room.databaseBuilder(
            appContext,
            MusicDB::class.java,
            "music_spotify_demo_db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideAlbumDao(database: MusicDB): AlbumDao {
        return database.albumDao()
    }

    @Provides
    @Singleton
    fun provideArtistDao(database: MusicDB): ArtistDao {
        return database.artistDao()
    }

    @Provides
    @Singleton
    fun provideAudioBookDao(database: MusicDB): AudioBookDao {
        return database.audioBookDao()
    }

    @Provides
    @Singleton
    fun providePlayListDao(database: MusicDB): PlayListDao {
        return database.playListDao()
    }

    @Provides
    @Singleton
    fun provideEpisodeDao(database: MusicDB): EpisodeDao {
        return database.episodeDao()
    }

    @Provides
    @Singleton
    fun provideShowDao(database: MusicDB): ShowDao {
        return database.showDao()
    }

    @Provides
    @Singleton
    fun provideTrackDao(database: MusicDB): TrackDao {
        return database.trackDao()
    }

    @Provides
    @Singleton
    fun provideSearchLocalRepository(
        albumDao: AlbumDao,
        artistDao: ArtistDao,
        audioBookDao: AudioBookDao,
        episodeDao: EpisodeDao,
        playListDao: PlayListDao,
        showDao: ShowDao,
        trackDao: TrackDao
    ) = SearchLocalRepository(
        albumDao, artistDao, audioBookDao, episodeDao, playListDao, showDao, trackDao
    )

    @Provides
    @Singleton
    fun provideSearchRemoteRepository(
        musicApi: MusicApi
    ) = SearchRemoteRepository(musicApi)


    @Provides
    @Singleton
    fun provideAuthRepository(
        authApi: AuthApi
    ) = AuthRepository(authApi)


    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext appContext: Context): SharedPreferences = appContext.getSharedPreferences(appContext.getString(
        R.string.app_name), Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun provideAuthApi(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): AuthApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_AUTH_URL)
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .client(
            OkHttpClient
                .Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
        )
        .build()
        .create(AuthApi::class.java)

    @Singleton
    @Provides
    fun provideMusicApi(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        sharedPreferences: SharedPreferences
    ): MusicApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_MUSIC_URL)
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .client(
            OkHttpClient
                .Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(AuthInterceptor(sharedPreferences))
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
        )
        .build()
        .create(MusicApi::class.java)
}
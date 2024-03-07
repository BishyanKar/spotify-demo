package com.example.spotifyassignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import net.danlew.android.joda.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class SpotifyApp: Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(
                Timber.DebugTree()
            )
        }
    }
}
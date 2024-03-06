package com.example.spotifyassignment

import android.app.Application
import net.danlew.android.joda.BuildConfig
import timber.log.Timber

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
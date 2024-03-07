package com.example.spotifyassignment.data.remote

import android.content.SharedPreferences
import com.example.spotifyassignment.Constants
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val sharedPreferences: SharedPreferences): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", sharedPreferences.getString(Constants.KEY_ACCESS_TOKEN,null) ?: "")
            .build()

        return chain.proceed(request)
    }
}
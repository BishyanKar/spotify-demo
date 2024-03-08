package com.example.spotifyassignment.ui.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.spotifyassignment.Constants
import com.example.spotifyassignment.R
import com.example.spotifyassignment.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var authViewModel: AuthViewModel

    @Inject
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editor = sharedPreferences.edit()

        authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]

        if (!isTokenValid()) {
            authenticate()
        } else {
            openSearchScreen()
        }
    }

    private fun isTokenValid(): Boolean {
        val token = sharedPreferences.getString(Constants.KEY_ACCESS_TOKEN, null);
        val expiresIn = sharedPreferences.getLong(Constants.KEY_ACCESS_TOKEN_EXPIRY_TIME, 1)
        val createdAt = sharedPreferences.getLong(Constants.KEY_ACCESS_TOKEN_CREATED_AT_MILLIS, 0)

        if (token == null) {
            return false
        }
        else {
            return System.currentTimeMillis() - createdAt < expiresIn*1000 - 10
        }
    }

    private fun authenticate() {
        authViewModel.authenticate().observe(this, Observer {apiResponse->
            if (apiResponse.isSuccessful && apiResponse.body != null) {
                val tokenResponse = apiResponse.body;
                if (tokenResponse.accessToken == null) {
                    Timber.e(tokenResponse.error)
                    Toast.makeText(this, resources.getString(R.string.text_authentication_failed), Toast.LENGTH_SHORT).show()
                } else {
                    editor.putString(Constants.KEY_ACCESS_TOKEN, tokenResponse.accessToken)
                    editor.putLong(Constants.KEY_ACCESS_TOKEN_EXPIRY_TIME, tokenResponse.expiresIn ?: 3600)
                    editor.putLong(Constants.KEY_ACCESS_TOKEN_CREATED_AT_MILLIS, System.currentTimeMillis())
                    editor.apply()
                    openSearchScreen()
                }
            } else {
                Timber.e(apiResponse.errorMessage)
                Toast.makeText(this, resources.getString(R.string.text_authentication_failed), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun openSearchScreen() {
        startActivity(
            Intent(this, SearchActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        )
    }
}
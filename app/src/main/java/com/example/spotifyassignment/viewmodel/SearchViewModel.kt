package com.example.spotifyassignment.viewmodel

import androidx.lifecycle.ViewModel
import com.example.spotifyassignment.repository.SearchLocalRepository
import com.example.spotifyassignment.repository.SearchRemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRemoteRepository: SearchRemoteRepository,
    private val searchLocalRepository: SearchLocalRepository
): ViewModel(){
}
package com.example.spotifyassignment.model.local

data class SearchItem(
    var id: String,
    var name: String,
    var img: String,
    var creator: String,
    var date: String? = ""
)
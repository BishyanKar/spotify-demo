package com.example.spotifyassignment.model.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class SearchItem(
    var id: String,
    var name: String,
    var img: String,
    var creator: String,
    var date: String? = "",
    var type: String
): Parcelable
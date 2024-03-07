package com.example.spotifyassignment.ui.adapter.listener

import android.widget.ImageView

interface SearchItemAdapterListener {
    fun onLoadImage(url: String, imageView: ImageView)
    fun onItemClick(id: String)
}
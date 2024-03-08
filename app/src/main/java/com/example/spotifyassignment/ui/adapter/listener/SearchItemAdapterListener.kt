package com.example.spotifyassignment.ui.adapter.listener

import android.widget.ImageView
import com.example.spotifyassignment.model.local.SearchItem

interface SearchItemAdapterListener {
    fun onLoadImage(url: String, imageView: ImageView)
    fun onItemClick(searchItem: SearchItem)
}
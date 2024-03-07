package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_album")
class AlbumEntity {

    @PrimaryKey
    var id: String? = null

    var albumType: String? = null

    var totalTracks: Int? = null

    var availableMarkets: List<String>? = null

    var albumDetailsLink: String? = null

    var imgUrls: List<String>? = null

    var name: String? = null

    var releaseDate: String? = null

    var releaseDatePrecision: String? = null

    var restrictionReason: String? = null

    var type: String? = null

    var uri: String? = null

    var artists: List<ArtistEntity>? = null
}
package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_artist")
class ArtistEntity {

    @PrimaryKey
    var id: String? = null

    var totalFollowers: Int? = null

    var genres: List<String>? = null

    var artistDetailsLink: String? = null

    var imgUrls: List<String>? = null

    var name: String? = null

    var popularity: Int? = null

    var type: String? = null

    var uri: String? = null
}
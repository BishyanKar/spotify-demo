package com.example.spotifyassignment.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "tbl_track")
class TrackEntity {

    @PrimaryKey
    var id: String? = null // PK

    var album: AlbumEntity? = null

    var artists: List<ArtistEntity>? = null

    var availableMarkets: List<String>? = null

    var discNumber: Int? = null

    var durationMs: Int? = null

    var explicit: Boolean? = null

    var trackDetailsLink: String? = null

    var isPlayable: Boolean? = null

    var restrictions: String? = null

    var name: String? = null

    var popularity: Int? = null

    var previewUrl: String? = null

    var trackNumber: Int? = null

    var type: String? = null

    var uri: String? = null

    var isLocal: Boolean? = null
}


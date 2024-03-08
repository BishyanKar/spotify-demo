package com.example.spotifyassignment.model.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class SearchItem(
    var id: String,
    var name: String,
    var img: String,
    var author: String? = "",
    var date: String? = "",
    var type: String,
    var description: String? = "",
    var duration: String? = "",
    var totalTracks: String? = "",
    var totalFollowers: String? = "",
    var genres: String? = "",
    var narrators: String? = "",
    var totalChapters: String? = "",
    var albumName: String? = "",
    var publisher: String? = "",
    var totalEpisodes: String? = ""
): Parcelable {
    fun getFormattedStrings(): List<String> {
        val itemList = arrayListOf<String>()

        if (name.isNotEmpty()) itemList.add("Name: $name")
        if (!author.isNullOrEmpty()) itemList.add("Creator: $author")
        if (!date.isNullOrEmpty()) itemList.add("Date: $date")
        if (!description.isNullOrEmpty()) itemList.add("Description: $description")
        if (!duration.isNullOrEmpty()) itemList.add("Duration: $duration")
        if (!totalTracks.isNullOrEmpty()) itemList.add("Total Tracks: $totalTracks")
        if (!totalFollowers.isNullOrEmpty()) itemList.add("Total Followers: $totalFollowers")
        if (!genres.isNullOrEmpty()) itemList.add("Genres: $genres")
        if (!narrators.isNullOrEmpty()) itemList.add("Narrators: $narrators")
        if (!totalChapters.isNullOrEmpty()) itemList.add("Total Chapters: $totalChapters")
        if (!albumName.isNullOrEmpty()) itemList.add("Album Name: $albumName")
        if (!publisher.isNullOrEmpty()) itemList.add("Publisher: $publisher")
        if (!totalEpisodes.isNullOrEmpty()) itemList.add("Total Episodes: $totalEpisodes")

        return itemList
    }
}
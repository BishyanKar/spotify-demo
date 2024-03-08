package com.example.spotifyassignment.model.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


/**
 * Represents an item returned from a search.
 *
 * @param id The unique identifier of the search item.
 * @param name The name of the search item.
 * @param img The image URL of the search item.
 * @param author The author of the search item.
 * @param date The date of the search item.
 * @param type The type of the search item.
 * @param description The description of the search item.
 * @param duration The duration of the search item.
 * @param totalTracks The total tracks of the search item.
 * @param totalFollowers The total followers of the search item.
 * @param genres The genres of the search item.
 * @param narrators The narrators of the search item.
 * @param totalChapters The total chapters of the search item.
 * @param albumName The album name of the search item.
 * @param publisher The publisher of the search item.
 * @param totalEpisodes The total episodes of the search item.
 */
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
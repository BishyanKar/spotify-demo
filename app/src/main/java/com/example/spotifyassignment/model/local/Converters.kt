package com.example.spotifyassignment.model.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {
    @TypeConverter
    fun fromJsonToStrings(json: String?): List<String>? {
        val listType: Type = object : TypeToken<List<String?>?>() {}.type
        return json?.let {
            Gson().fromJson(it, listType)
        }
    }

    @TypeConverter
    fun toJsonFromStrings(list: List<String>?): String? {
        return list?.let {
            Gson().toJson(it)
        }
    }

    @TypeConverter
    fun fromJsonToArtists(json: String?): List<ArtistEntity>? {
        val listType: Type = object : TypeToken<List<ArtistEntity?>?>() {}.type
        return json?.let {
            Gson().fromJson(it, listType)
        }
    }

    @TypeConverter
    fun toJsonFromArtists(list: List<ArtistEntity>?): String? {
        return list?.let {
            Gson().toJson(it)
        }
    }

    @TypeConverter
    fun fromJsonToAlbums(json: String?): List<AlbumEntity>? {
        val listType: Type = object : TypeToken<List<AlbumEntity?>?>() {}.type
        return json?.let {
            Gson().fromJson(it, listType)
        }
    }

    @TypeConverter
    fun toJsonFromAlbums(list: List<AlbumEntity>?): String? {
        return list?.let {
            Gson().toJson(it)
        }
    }

    @TypeConverter
    fun fromJsonToCopyRights(json: String?): List<CopyrightEntity>? {
        val listType: Type = object : TypeToken<List<CopyrightEntity?>?>() {}.type
        return json?.let {
            Gson().fromJson(it, listType)
        }
    }

    @TypeConverter
    fun toJsonFromCopyRights(list: List<CopyrightEntity>?): String? {
        return list?.let {
            Gson().toJson(it)
        }
    }
}
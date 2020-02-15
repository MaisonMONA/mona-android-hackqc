package com.example.mona

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class LocationConverter {

    @TypeConverter
    fun toLocation(json: String): Location {
        val type = object : TypeToken<Location>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(location: Location): String {
        val type = object: TypeToken<Location>() {}.type
        return Gson().toJson(location, type)
    }

}
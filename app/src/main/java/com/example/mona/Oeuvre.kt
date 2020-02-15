package com.example.mona

// All data properties of an artwork
// Bult in Moshi Adapter translates them directly into its instance
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable


@Entity(tableName = "artwork_table")
@JsonClass(generateAdapter = true)
data class Oeuvre(

    @PrimaryKey(autoGenerate = true)
    val id: Int?,

    var title: String?,

    var produced_at: String?,

    @TypeConverters(BilingualConverter::class)
    @field:Json(name = "category") var category: Bilingual?,

    @TypeConverters(BilingualConverter::class)
    @field:Json(name = "subcategory") var subcategory: Bilingual?,

    @TypeConverters(DimensionConverter::class)
    @field:Json(name = "dimensions") var dimension: List<Any>?,

    @TypeConverters(BilingualListConverter::class)
    @field:Json(name = "materials") var materials: List<Bilingual>?,

    @TypeConverters(BilingualListConverter::class)
    @field:Json(name = "techniques") var techniques: List<Bilingual>?,

    @TypeConverters(ArtistConverter::class)
    @field:Json(name = "artists") var artists: List<Artist>?,

    var borough: String?,

    @TypeConverters(LocationConverter::class)
    @field:Json(name = "location") var location: Location?,

    var collection: String?,

    var details: String?
) : Serializable


data class Bilingual(
    var fr: String,
    var en: String
) : Serializable

data class Location(
    var lat: Double,
    var lng: Double
) : Serializable

data class Artist(
    var id: Int,
    var name: String,
    var alias: String,
    var collective: Boolean

) : Serializable

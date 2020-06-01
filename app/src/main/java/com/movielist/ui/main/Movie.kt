package com.movielist.ui.main

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Movie (
    val imdbID: String,
    @Json(name = "Title") val title: String,
    @Json(name = "Year") val year: String,
    @Json(name = "Type") val type: String,
    @Json(name = "Poster") val imgUrl: String
) : Parcelable

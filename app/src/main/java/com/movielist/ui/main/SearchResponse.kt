package com.movielist.ui.main

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class SearchResponse (
    @Json(name = "Search") val search: List<Movie>,
    val totalResults: Int,
    @Json(name = "Response") val response: String
) : Parcelable

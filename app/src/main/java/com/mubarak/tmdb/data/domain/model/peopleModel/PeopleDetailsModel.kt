package com.mubarak.tmdb.data.domain.model.peopleModel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PeopleDetailsModel(
    val adult: Boolean,
    val alsoKnownAs: List<String>,
    val biography: String,
    val birthday: String,
    val deathday: String,
    val gender: Int,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val knownForDepartment: String,
    val name: String,
    val placeOfBirth: String,
    val popularity: Double,
    val profilePath: String
): Parcelable


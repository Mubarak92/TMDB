package com.mubarak.tmdb.data.domain.model.peopleModel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PeopleModel(
    val page: Int? = null,
    val totalPages: Int? = null,
    val results: List<PeopleResultsItem?>? = null,
    val totalResults: Int? = null
) : Parcelable


@Parcelize
data class PeopleResultsItem(
    val gender: Int? = null,
    val mediaType: String? = null,
    val knownForDepartment: String? = null,
    val originalName: String? = null,
    val popularity: Double? = null,
    val knownFor: List<PeopleKnownForItem>? = null,
    val name: String? = null,
    val profilePath: String? = null,
    val id: Int? = null,
    val adult: Boolean? = null
) : Parcelable

@Parcelize
data class PeopleKnownForItem(
    val overview: String? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val video: Boolean? = null,
    val title: String? = null,
    val genreIds: List<Int?>? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val mediaType: String? = null,
    val releaseDate: String? = null,
    val popularity: Double? = null,
    val voteAverage: Double? = null,
    val id: Int? = null,
    val adult: Boolean? = null,
    val voteCount: Int? = null
) : Parcelable



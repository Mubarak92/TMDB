package com.mubarak.tmdb.data.network.model.apiPeopleModel

import com.google.gson.annotations.SerializedName


data class ApiPeopleMovieCredits(
    @SerializedName("cast") val cast: List<CastItem> = emptyList(),
    @SerializedName("crew") val crew: List<Crew> = emptyList(),
    @SerializedName("id") val id: Int? = null,
)

data class CastItem(
    @SerializedName("adult") val adult: Boolean? = null,
    @SerializedName("backdrop_path") val backdropPath: String? = null,
    @SerializedName("genre_ids") val genreIds: List<Int> = emptyList(),
    @SerializedName("id") val id: Int? = null,
    @SerializedName("original_language") val originalLanguage: String? = null,
    @SerializedName("original_title") val originalTitle: String? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("popularity") val popularity: Double? = null,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("release_date") val releaseDate: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("video") val video: Boolean? = null,
    @SerializedName("vote_average") val voteAverage: Double? = null,
    @SerializedName("vote_count") val voteCount: Int? = null,
    @SerializedName("character") val character: String? = null,
    @SerializedName("credit_id") val creditId: String? = null,
    @SerializedName("order") val order: Int? = null
)


data class Crew(

    @SerializedName("adult") val adult: Boolean? = null,
    @SerializedName("backdrop_path") val backdropPath: String? = null,
    @SerializedName("genre_ids") val genreIds: ArrayList<Int> = arrayListOf(),
    @SerializedName("id") val id: Int? = null,
    @SerializedName("original_language") val originalLanguage: String? = null,
    @SerializedName("original_title") val originalTitle: String? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("popularity") val popularity: Double? = null,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("release_date") val releaseDate: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("video") val video: Boolean? = null,
    @SerializedName("vote_average") val voteAverage: Double? = null,
    @SerializedName("vote_count") val voteCount: Int? = null,
    @SerializedName("credit_id") val creditId: String? = null,
    @SerializedName("department") val department: String? = null,
    @SerializedName("job") val job: String? = null

)
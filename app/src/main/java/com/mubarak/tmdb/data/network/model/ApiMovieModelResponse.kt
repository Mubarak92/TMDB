package com.mubarak.tmdb.data.network.model

import com.google.gson.annotations.SerializedName
import com.mubarak.tmdb.data.domain.model.MovieItem
import com.mubarak.tmdb.data.network.model.ApiMovieItem.Companion.toUiMovie
import java.io.Serializable

data class ApiMovieModelResponse(
    @SerializedName("page")
    val page: Int? = null,

    @SerializedName("total_pages")
    val totalPages: Int? = null,

    @SerializedName("results")
    val results: List<ApiMovieItem>? = null,

    @SerializedName("total_results")
    val totalResults: Int? = null
) {
    companion object {
        fun ApiMovieModelResponse.toUiMovieList() = this.results?.map {
            it.toUiMovie()
        }
    }
}


data class ApiMovieItem(

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("original_language")
    val originalLanguage: String? = null,

    @SerializedName("original_title")
    val originalTitle: String? = null,

    @SerializedName("video")
    val video: Boolean? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("genre_ids")
    val genreIds: List<Int?>? = null,

    @SerializedName("poster_path")
    val posterPath: String? = null,

    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @SerializedName("release_date")
    val releaseDate: String? = null,

    @SerializedName("popularity")
    val popularity: Double? = null,

    @SerializedName("vote_average")
    val voteAverage: Double? = null,

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("adult")
    val adult: Boolean? = null,

    @SerializedName("vote_count")
    val voteCount: Int? = null
) : Serializable {
    companion object {
        fun ApiMovieItem.toUiMovie() = MovieItem(
            this.overview,
            this.originalLanguage,
            this.originalTitle,
            this.video,
            this.title,
            this.name,
            this.genreIds,
            this.posterPath,
            this.backdropPath,
            this.releaseDate,
            this.popularity,
            this.voteAverage,
            this.id,
            this.adult,
            this.voteCount
        )
    }
}
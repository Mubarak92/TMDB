package com.mubarak.tmdb.data.network.model.apiMovieModel

import com.google.gson.annotations.SerializedName
import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieItem.Companion.toUiMovie
import com.mubarak.tmdb.domain.model.movieModel.MovieItem
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
    val id: Int,

    @SerializedName("adult")
    val adult: Boolean? = null,

    @SerializedName("vote_count")
    val voteCount: Int? = null
) : Serializable {
    companion object {
        fun ApiMovieItem.toUiMovie() = MovieItem(
            overview = this.overview,
            originalLanguage = this.originalLanguage,
            originalTitle = this.originalTitle,
            video = this.video,
            title = this.title,
            name = this.name,
            posterPath = this.posterPath,
            backdropPath = this.backdropPath,
            releaseDate = this.releaseDate,
            popularity = this.popularity,
            voteAverage = this.voteAverage,
            id = this.id,
            adult = this.adult,
            voteCount = this.voteCount
        )
    }
}
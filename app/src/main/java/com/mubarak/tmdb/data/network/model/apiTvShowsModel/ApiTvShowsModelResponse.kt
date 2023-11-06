package com.mubarak.tmdb.data.network.model.apiTvShowsModel

import com.google.gson.annotations.SerializedName
import com.mubarak.tmdb.data.network.model.apiTvShowsModel.ApiTvShowItem.Companion.toUiTvShows
import com.mubarak.tmdb.domain.model.tvShowsModel.TvShowsItem
import java.io.Serializable

data class ApiTvShowsModelResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("results")
    val results: List<ApiTvShowItem>,
    @SerializedName("total_results")
    val totalResults: Int
) {
    companion object {
        fun ApiTvShowsModelResponse.toUiTvShowsList() = this.results.map {
            it.toUiTvShows()
        }
    }
}

data class ApiTvShowItem(
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("vote_count")
    val voteCount: Int

) : Serializable {
    companion object {
        fun ApiTvShowItem.toUiTvShows() = TvShowsItem(
            firstAirDate = firstAirDate,
            overview = overview,
            originalLanguage = originalLanguage,
            genreIds = genreIds,
            posterPath = posterPath,
            originCountry = originCountry,
            backdropPath = backdropPath,
            originalName = originalName,
            popularity = popularity,
            voteAverage = voteAverage,
            name = name,
            id = id,
            adult = adult,
            voteCount = voteCount

        )
    }
}

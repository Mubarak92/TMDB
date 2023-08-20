package com.mubarak.tmdb.data.network.model.apiPeopleModel

import com.google.gson.annotations.SerializedName
import com.mubarak.tmdb.data.domain.model.peopleModel.PeopleKnownForItem
import com.mubarak.tmdb.data.domain.model.peopleModel.PeopleResultsItem
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleKnownFor.Companion.toUiPeopleKnownFor
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleResult.Companion.toUiPeopleResult
import java.io.Serializable

data class ApiPeopleModelResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<ApiPeopleResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
) {
    companion object {
        fun ApiPeopleModelResponse.toUiPeopleList() = this.results.map {
            it.toUiPeopleResult()
        }
    }
}

data class ApiPeopleResult(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("gender")
    val gender: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("known_for")
    val knownFor: List<ApiPeopleKnownFor>,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String
) : Serializable {
    companion object {
        fun ApiPeopleResult.toUiPeopleResult() = PeopleResultsItem(
            adult = adult,
            id = id,
            gender = gender,
            mediaType = mediaType,
            knownForDepartment = knownForDepartment,
            knownFor =
            this.knownFor.map {
                it.toUiPeopleKnownFor()
            },
            originalName = originalName,
            popularity = popularity,
            name = name,
            profilePath = profilePath
        )
    }
}

data class ApiPeopleKnownFor(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
) : Serializable {
    companion object {
        fun ApiPeopleKnownFor.toUiPeopleKnownFor() = PeopleKnownForItem(
            overview,
            originalLanguage,
            originalTitle,
            video,
            title,
            genreIds,
            posterPath,
            backdropPath,
            mediaType,
            releaseDate,
            popularity,
            voteAverage,
            id,
            adult,
            voteCount
        )
    }
}
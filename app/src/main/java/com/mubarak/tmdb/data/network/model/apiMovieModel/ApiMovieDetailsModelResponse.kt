package com.mubarak.tmdb.data.network.model.apiMovieModel

import com.google.gson.annotations.SerializedName
import com.mubarak.tmdb.data.network.model.apiMovieModel.Genre.Companion.toUiGenre
import com.mubarak.tmdb.domain.model.movieModel.GenresItem
import com.mubarak.tmdb.domain.model.movieModel.MovieDetailsItem
import java.io.Serializable

data class ApiMovieDetailsModelResponse(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollection,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("homepage")
    val homepage: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
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
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("revenue")
    val revenue: Int,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    @SerializedName("status")
    val status: String,
    @SerializedName("tagline")
    val tagline: String,
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
        fun ApiMovieDetailsModelResponse.toUiDetails() = MovieDetailsItem(
            originalLanguage = originalLanguage,
            imdbId = imdbId,
            video = video,
            title = title,
            backdropPath = backdropPath,
            revenue = revenue,
            genres = genres.map {
                it.toUiGenre()
            },
            popularity = popularity,
            //	productionCountries = productionCountries,
            id = id,
            voteCount = voteCount,
            budget = budget,
            overview = overview,
            originalTitle = originalTitle,
            runtime = runtime,
            posterPath = posterPath,
            //	spokenLanguages = spokenLanguages,
            //	productionCompanies = productionCompanies,
            releaseDate = releaseDate,
            voteAverage = voteAverage,
            //	belongsToCollection = belongsToCollection,
            tagline = tagline,
            adult = adult,
            homepage = homepage,
            status = status,

            )
    }
}

data class BelongsToCollection(
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("poster_path")
    val posterPath: String
)

data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
) : Serializable {
    companion object {
        fun Genre.toUiGenre() = GenresItem(
            id = id,
            name = name
        )
    }

}

data class SpokenLanguage(
    @SerializedName("english_name")
    val englishName: String,
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("name")
    val name: String
)

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    val iso31661: String,
    @SerializedName("name")
    val name: String
)

data class ProductionCompany(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo_path")
    val logoPath: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String
)

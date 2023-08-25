package com.mubarak.tmdb.data.network.model.apiPeopleModel

import com.google.gson.annotations.SerializedName

data class ApiPeopleSocial(

    @SerializedName("id") val id: Int? = null,
    @SerializedName("freebase_mid") val freebaseMid: String? = null,
    @SerializedName("freebase_id") val freebaseId: String? = null,
    @SerializedName("imdb_id") val imdbId: String? = null,
    @SerializedName("tvrage_id") val tvrageId: String? = null,
    @SerializedName("wikidata_id") val wikidataId: String? = null,
    @SerializedName("facebook_id") val facebookId: String? = null,
    @SerializedName("instagram_id") val instagramId: String? = null,
    @SerializedName("tiktok_id") val tiktokId: String? = null,
    @SerializedName("twitter_id") val twitterId: String? = null,
    @SerializedName("youtube_id") val youtubeId: String? = null

)
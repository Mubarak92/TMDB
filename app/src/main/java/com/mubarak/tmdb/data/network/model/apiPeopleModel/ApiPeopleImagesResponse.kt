package com.mubarak.tmdb.data.network.model.apiPeopleModel

import com.google.gson.annotations.SerializedName
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ProfilesItem.Companion.toUiPeopleImages
import com.mubarak.tmdb.domain.model.peopleModel.PeopleImageItem
import java.io.Serializable

data class ApiPeopleImagesResponse(
    @SerializedName("profiles")
    val profiles: List<ProfilesItem?>? = null,
    @SerializedName("id")
    val id: Int? = null
) : Serializable {
    companion object {
        fun ApiPeopleImagesResponse.toUiPeopleImagesList() = this.profiles?.map {
            it?.toUiPeopleImages()
        }
    }
}

data class ProfilesItem(
    @SerializedName("file_path")
    val filePath: String? = null,
    @SerializedName("vote_count")
    val voteCount: Int? = null,
) : Serializable {
    companion object {
        fun ProfilesItem.toUiPeopleImages() = PeopleImageItem(
            this.filePath,
            this.voteCount
        )
    }
}



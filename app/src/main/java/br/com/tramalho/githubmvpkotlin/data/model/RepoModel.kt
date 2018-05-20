package br.com.tramalho.githubmvpkotlin.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by trama on 24/03/18.
 */
@Parcelize
data class RepoModel(
        @SerializedName("name")
        val name: String = "",
        @SerializedName("full_name")
        val fullName: String = "",
        @SerializedName("description")
        val description: String = "",
        @SerializedName("forks_count")
        val forksCount: Long = 0,
        @SerializedName("stargazers_count")
        val stargazersCount: Long = 0,
        @SerializedName("avatar_url")
        val avatarUrl: String? = "",
        @SerializedName("owner")
        val repoOwner: RepoOwner?
) : Parcelable
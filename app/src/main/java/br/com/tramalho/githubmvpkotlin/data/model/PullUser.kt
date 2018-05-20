package br.com.tramalho.githubmvpkotlin.data.model

import com.google.gson.annotations.SerializedName

data class PullUser(
        val login: String,
        @SerializedName("avatar_url")
        val avatarUrl: String
)
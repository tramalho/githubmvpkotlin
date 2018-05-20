package br.com.tramalho.githubmvpkotlin.data.model

import com.google.gson.annotations.SerializedName

data class PullModel(
        val title: String,
        val body:String,
        val user: PullUser,
        @SerializedName("html_url")
        val htmlUrl:String,
        @SerializedName("created_at")
        val createdAt : String
)
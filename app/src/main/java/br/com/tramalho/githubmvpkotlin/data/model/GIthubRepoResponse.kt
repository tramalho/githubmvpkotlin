package br.com.tramalho.githubmvpkotlin.data.model

import com.google.gson.annotations.SerializedName


/**
 * Created by trama on 04/04/18.
 */
data class GithubRepoResponse(
        @SerializedName("items")
        val itens: List<RepoModel>? = null
)

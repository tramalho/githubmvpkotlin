package br.com.tramalho.githubmvpkotlin.repository

import android.util.Log
import br.com.tramalho.githubmvpkotlin.BuildConfig
import br.com.tramalho.githubmvpkotlin.data.model.GithubRepoResponse
import br.com.tramalho.githubmvpkotlin.data.model.PullModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL
import javax.inject.Inject

open class GithubRepository {

    open fun listByFilter(sort: String, language: String): GithubRepoResponse {

        val url = composeUrlRepo(language, sort)
        val readText = url.readText()

        log(readText, url)

        return Gson().fromJson(readText, GithubRepoResponse::class.java)
    }

    fun pullRequestRepo(login: String?, name: String): List<PullModel> {
        val url = composeUrlPull(login, name)
        val readText = url.readText()

        log(readText, url)

        return Gson().fromJson(readText, object : TypeToken<List<PullModel>>() {}.type)
    }


    private fun composeUrlRepo(language: String, sort: String): URL {
        val url = "${Constants.BASE_URL}/${Constants.REPO_URL}?q=language:$language&sort=$sort&page=0"
        return URL(url)
    }


    private fun composeUrlPull(login: String?, name: String): URL {
        var url = "${Constants.BASE_URL}/${Constants.PULL_URL}"
        url = url.replace("{creator}", login!!).replace("{repo}", name)
        return URL(url)
    }

    private fun log(readText: String, url: URL) {
        if (BuildConfig.DEBUG) {
            Log.d(this.javaClass.simpleName, readText)
            Log.d(this.javaClass.simpleName, url.toString())
        }
    }
}

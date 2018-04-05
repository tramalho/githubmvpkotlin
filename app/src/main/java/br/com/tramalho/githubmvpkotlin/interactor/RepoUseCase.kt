package br.com.tramalho.githubmvpkotlin.interactor

import android.util.Log
import br.com.tramalho.githubmvpkotlin.data.model.GithubRepoResponse
import br.com.tramalho.githubmvpkotlin.data.model.RepoModel
import br.com.tramalho.githubmvpkotlin.repository.Constants
import com.google.gson.Gson
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import java.net.URL

class RepoUseCase {

    interface RepoUseCaseContract {
        fun onSuccess(result: List<RepoModel>)
        fun onError()
    }

    fun retrieve(language: String, sort: String, contract: RepoUseCaseContract) {
        launch(UI) {
            val task = async {

                val url = composeUrl(language, sort)
                val readText = url.readText()

                Log.d(this.javaClass.simpleName, readText)
                Log.d(this.javaClass.simpleName, url.toString())

                Gson().fromJson(readText, GithubRepoResponse::class.java)
            }
            val result = task.await() as GithubRepoResponse
            contract.onSuccess(result.itens ?: emptyList())
        }
    }

    private fun composeUrl(language: String, sort: String): URL {
        val url = "${Constants.BASE_URL}/${Constants.REPO_URL}?q=language:$language&sort=$sort&page=0"
        return URL(url)
    }
}


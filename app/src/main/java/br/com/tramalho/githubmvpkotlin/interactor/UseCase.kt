package br.com.tramalho.githubmvpkotlin.interactor

import br.com.tramalho.githubmvpkotlin.data.model.GithubRepoResponse
import br.com.tramalho.githubmvpkotlin.data.model.PullModel
import br.com.tramalho.githubmvpkotlin.data.model.RepoModel
import br.com.tramalho.githubmvpkotlin.repository.GithubRepository
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import javax.inject.Singleton

@Singleton
class UseCase(private val githubRepository: GithubRepository) {

    interface UseCaseContract<T> {
        fun onSuccess(result: List<T>)
        fun onError()
    }

    fun retriveRepos(language: String, sort: String, contract: UseCaseContract<RepoModel>) {
        val request = { githubRepository.listByFilter(sort, language) }

        val actionSuccess = { result:Any ->
            if (result is GithubRepoResponse) {
                contract.onSuccess(result.itens ?: emptyList())
            }
        }

        runAsync(request, actionSuccess)
    }

    fun retrivePullRequests(repoModel:RepoModel, contract: UseCaseContract<PullModel>) {

        val request = {
            val owner = repoModel.repoOwner
            githubRepository.pullRequestRepo(owner?.login, repoModel.name)
        }

        runAsync(request) { res ->
            contract.onSuccess(res as List<PullModel>)
        }
    }

    //high order assync function
   private fun runAsync(request: () -> Any, response: (Any) -> Unit) {

        launch(UI) {
            val task = async {
                request.invoke()
            }

            val result = task.await()
            response.invoke(result)
        }
    }
}


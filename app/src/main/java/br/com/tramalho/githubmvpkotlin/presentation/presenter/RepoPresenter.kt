package br.com.tramalho.githubmvpkotlin.presentation.presenter

import br.com.tramalho.githubmvpkotlin.data.model.RepoModel
import br.com.tramalho.githubmvpkotlin.interactor.RepoUseCase

class RepoPresenter(private val contractView: RepoContractView, val repoUseCase: RepoUseCase) {

    interface RepoContractView{
        fun onSuccess(result : List<RepoModel>)
        fun onError()
    }

    fun retrieve(language: String, sort: String) {
        repoUseCase.retrieve(language, sort, PresenterCallBack(contractView))
    }

    private class PresenterCallBack(private val contractView: RepoPresenter.RepoContractView) :
            RepoUseCase.RepoUseCaseContract {

        override fun onSuccess(result : List<RepoModel>) {
            contractView.onSuccess(result)
        }

        override fun onError() {
           contractView.onError()
        }
    }
}

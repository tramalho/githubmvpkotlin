package br.com.tramalho.githubmvpkotlin.presentation.presenter

import br.com.tramalho.githubmvpkotlin.data.model.RepoModel
import br.com.tramalho.githubmvpkotlin.interactor.UseCase

class RepoPresenter(private val contractView: RepoContractView, val useCase: UseCase) {

    interface RepoContractView{
        fun onSuccess(result : List<RepoModel>)
        fun onError()
    }

    fun retrieve(language: String, sort: String) {
        useCase.retriveRepos(language, sort, PresenterCallBack(contractView))
    }

    private class PresenterCallBack(private val contractView: RepoPresenter.RepoContractView) :
            UseCase.UseCaseContract<RepoModel> {

        override fun onSuccess(result : List<RepoModel>) {
            contractView.onSuccess(result)
        }

        override fun onError() {
           contractView.onError()
        }
    }
}

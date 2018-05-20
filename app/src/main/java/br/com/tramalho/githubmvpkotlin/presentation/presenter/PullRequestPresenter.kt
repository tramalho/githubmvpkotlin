package br.com.tramalho.githubmvpkotlin.presentation.presenter

import br.com.tramalho.githubmvpkotlin.data.model.PullModel
import br.com.tramalho.githubmvpkotlin.data.model.RepoModel
import br.com.tramalho.githubmvpkotlin.interactor.UseCase

class PullRequestPresenter(private val contractView: PullContractView, val useCase: UseCase) {

    interface PullContractView{
        fun onSuccess(result : List<PullModel>)
        fun onError()
    }

    fun retrieve(model: RepoModel) {
        useCase.retrivePullRequests(model, PresenterCallBack(contractView))
    }

    private class PresenterCallBack(private val contractView: PullRequestPresenter.PullContractView) :
            UseCase.UseCaseContract<PullModel> {

        override fun onSuccess(result : List<PullModel>) {
            contractView.onSuccess(result)
        }

        override fun onError() {
           contractView.onError()
        }
    }
}

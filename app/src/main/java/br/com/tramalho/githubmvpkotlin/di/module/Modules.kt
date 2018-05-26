package br.com.tramalho.githubmvpkotlin.di.module

import br.com.tramalho.githubmvpkotlin.interactor.UseCase
import br.com.tramalho.githubmvpkotlin.presentation.presenter.PullRequestPresenter
import br.com.tramalho.githubmvpkotlin.presentation.presenter.RepoPresenter
import br.com.tramalho.githubmvpkotlin.repository.GithubRepository
import dagger.Module
import dagger.Provides

@Module
class Modules {

    @Provides
    fun providesRepoPresenter(useCase: UseCase): RepoPresenter {
        return RepoPresenter(useCase)
    }

    @Provides
    fun providesPullRequestPresenter(useCase: UseCase): PullRequestPresenter {
        return PullRequestPresenter(useCase)
    }

    @Provides
    fun providesUseCase(githubRepository: GithubRepository): UseCase {
        return UseCase(githubRepository)
    }
}

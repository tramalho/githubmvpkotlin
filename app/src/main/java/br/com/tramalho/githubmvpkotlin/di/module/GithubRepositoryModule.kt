package br.com.tramalho.githubmvpkotlin.di.module

import br.com.tramalho.githubmvpkotlin.repository.GithubRepository
import dagger.Module
import dagger.Provides

@Module
open class GithubRepositoryModule {

    @Provides
    open fun providesRepository(): GithubRepository {
        return GithubRepository()
    }
}
package br.com.tramalho.githubmvpkotlin.di.module

import br.com.tramalho.githubmvpkotlin.setup.repository.MockGithubRepository
import br.com.tramalho.githubmvpkotlin.repository.GithubRepository
import dagger.Module
import dagger.Provides

@Module
open class MockRepositoryModule : GithubRepositoryModule() {

    @Provides
    override fun providesRepository(): GithubRepository {
        return MockGithubRepository()
    }
}
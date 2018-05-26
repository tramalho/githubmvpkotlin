package br.com.tramalho.githubmvpkotlin.di.component

import br.com.tramalho.githubmvpkotlin.di.module.GithubRepositoryModule
import br.com.tramalho.githubmvpkotlin.di.module.Modules
import br.com.tramalho.githubmvpkotlin.presentation.MainActivity
import br.com.tramalho.githubmvpkotlin.presentation.PullDetailActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(Modules::class, GithubRepositoryModule::class))
interface PresenterComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(pullDetailActivity: PullDetailActivity)
}
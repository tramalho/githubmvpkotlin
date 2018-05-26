package br.com.tramalho.githubmvpkotlin.di

import br.com.tramalho.githubmvpkotlin.di.component.DaggerPresenterComponent
import br.com.tramalho.githubmvpkotlin.di.component.PresenterComponent
import br.com.tramalho.githubmvpkotlin.presentation.MainActivity
import br.com.tramalho.githubmvpkotlin.presentation.PullDetailActivity

class ComponentBuilder {

    private fun builder(): PresenterComponent {
        return DaggerPresenterComponent
                .builder()
                .build()
    }

    fun inject(mainActivity: MainActivity) {
        val component = builder()
        component.inject(mainActivity)
    }

    fun inject(pullDetailActivity: PullDetailActivity) {
        val component = builder()
        component.inject(pullDetailActivity)
    }
}

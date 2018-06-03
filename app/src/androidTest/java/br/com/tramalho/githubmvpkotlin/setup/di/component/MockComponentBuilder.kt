package br.com.tramalho.githubmvpkotlin.di

import br.com.tramalho.githubmvpkotlin.di.component.DaggerPresenterComponent
import br.com.tramalho.githubmvpkotlin.di.component.PresenterComponent
import br.com.tramalho.githubmvpkotlin.di.module.MockRepositoryModule

class MockComponentBuilder : ComponentBuilder() {

     override fun builder(): PresenterComponent {
        return DaggerPresenterComponent
                .builder()
                .githubRepositoryModule(MockRepositoryModule())
                .build()
    }
}
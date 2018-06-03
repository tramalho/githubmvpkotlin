package br.com.tramalho.githubmvpkotlin.setup.infraestructure

import br.com.tramalho.githubmvpkotlin.di.ComponentBuilder
import br.com.tramalho.githubmvpkotlin.di.MockComponentBuilder
import br.com.tramalho.githubmvpkotlin.infraestructure.CustomApplicationImpl

class CustomMockApplication : CustomApplicationImpl() {

    override fun builder(): ComponentBuilder {
        return MockComponentBuilder()
    }
}
package br.com.tramalho.githubmvpkotlin.infraestructure

import br.com.tramalho.githubmvpkotlin.di.ComponentBuilder

interface CustomApplication {

    fun builder() : ComponentBuilder
}

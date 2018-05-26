package br.com.tramalho.githubmvpkotlin.infraestructure

import android.app.Application
import br.com.tramalho.githubmvpkotlin.di.ComponentBuilder

class CustomApplicationImpl : Application(), CustomApplication {

    override fun builder() = ComponentBuilder()
}
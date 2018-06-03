package br.com.tramalho.githubmvpkotlin.infraestructure

import android.app.Application
import br.com.tramalho.githubmvpkotlin.di.ComponentBuilder

open class CustomApplicationImpl : Application() {

    open fun builder() = ComponentBuilder()
}
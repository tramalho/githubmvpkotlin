package br.com.tramalho.githubmvpkotlin.setup.repository

import br.com.tramalho.githubmvpkotlin.data.model.GithubRepoResponse
import br.com.tramalho.githubmvpkotlin.repository.GithubRepository
import com.google.gson.Gson
import java.io.InputStreamReader
import kotlin.reflect.KClass

class MockGithubRepository : GithubRepository()  {

    private fun openFile(pathFile: String, clazz: KClass<GithubRepoResponse>): Any{
        val classLoader = this.javaClass.classLoader
        val resourceAsStream = classLoader.getResourceAsStream(pathFile)
        return Gson().fromJson(InputStreamReader(resourceAsStream), clazz.java)
    }

    override fun listByFilter(sort: String, language: String): GithubRepoResponse {

        val openFile = openFile("assets/two_results.json", GithubRepoResponse::class)

        return openFile as GithubRepoResponse
    }
}
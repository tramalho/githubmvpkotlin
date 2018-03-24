package br.com.tramalho.githubmvpkotlin.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.tramalho.githubmvpkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupReciclerView()
    }

    private fun setupReciclerView() {

        repoListRecycler.layoutManager = LinearLayoutManager(this)

        repoListRecycler.adapter = RepoListAdapter(arrayListOf(""))
    }
}

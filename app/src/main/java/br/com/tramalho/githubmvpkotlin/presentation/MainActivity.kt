package br.com.tramalho.githubmvpkotlin.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import br.com.tramalho.githubmvpkotlin.R
import br.com.tramalho.githubmvpkotlin.data.model.RepoModel
import br.com.tramalho.githubmvpkotlin.infraestructure.DataStatus
import br.com.tramalho.githubmvpkotlin.interactor.UseCase
import br.com.tramalho.githubmvpkotlin.presentation.presenter.RepoPresenter
import br.com.tramalho.githubmvpkotlin.infraestructure.showShort
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RepoPresenter.RepoContractView, RepoListAdapter.OnItemClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupReciclerView()
        initialize()
    }

    private fun initialize() {
        RepoPresenter(this, UseCase())
                .retrieve("java", "stars")
    }

    private fun setupReciclerView() {

        repoListRecycler.layoutManager = LinearLayoutManager(this)

        repoListRecycler.adapter = RepoListAdapter(mutableListOf<RepoModel>(), this)
    }

    override fun onSuccess(result: List<RepoModel>) {
        val adapter = this.repoListRecycler.adapter as RepoListAdapter
        adapter.updateItens(result)
        updateVisibility(DataStatus.HAS_ITENS)
    }

    private fun updateVisibility(status: DataStatus) {

        var showMore = GONE
        var showItem = GONE
        var repoRV = VISIBLE

        if (status.equals(DataStatus.HAS_ITENS)) {
            showMore = GONE
            showItem = GONE
            repoRV = VISIBLE
        }

        show_more_progress.visibility = showMore
        show_item_progressBar.visibility = showItem
        repoListRecycler.visibility = repoRV
    }

    override fun onError() {
        showShort("Falha")
    }

    override fun onClick(repoEntity: RepoModel) {
        PullDetailActivity.launchActivity(this , repoEntity)
    }
}

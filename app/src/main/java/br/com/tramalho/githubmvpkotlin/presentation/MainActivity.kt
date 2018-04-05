package br.com.tramalho.githubmvpkotlin.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import br.com.tramalho.githubmvpkotlin.R
import br.com.tramalho.githubmvpkotlin.data.model.RepoModel
import br.com.tramalho.githubmvpkotlin.interactor.RepoUseCase
import br.com.tramalho.githubmvpkotlin.presentation.presenter.RepoPresenter
import br.com.tramalho.githubmvpkotlin.presentation.utils.showShort
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RepoPresenter.RepoContractView {

    enum class DataStatus{
        HAS_ITENS, ERROR, NO_ITENS
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupReciclerView()
        init()
    }

    private fun init() {
        RepoPresenter(this, RepoUseCase())
                .retrieve("java", "stars")
    }

    private fun setupReciclerView() {

        repoListRecycler.layoutManager = LinearLayoutManager(this)

        repoListRecycler.adapter = RepoListAdapter(mutableListOf<RepoModel>())
    }

    override fun onSuccess(result: List<RepoModel>) {
        val adapter = this.repoListRecycler.adapter as RepoListAdapter
        adapter.updateItens(repoModel = result)
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
        showShort(this, "Falha")
    }

}

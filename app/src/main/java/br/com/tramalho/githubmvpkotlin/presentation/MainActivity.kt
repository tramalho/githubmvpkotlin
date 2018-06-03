package br.com.tramalho.githubmvpkotlin.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import br.com.tramalho.githubmvpkotlin.R
import br.com.tramalho.githubmvpkotlin.data.model.RepoModel
import br.com.tramalho.githubmvpkotlin.infraestructure.CustomApplicationImpl
import br.com.tramalho.githubmvpkotlin.infraestructure.DataStatus
import br.com.tramalho.githubmvpkotlin.presentation.presenter.RepoPresenter
import br.com.tramalho.githubmvpkotlin.infraestructure.showShort
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), RepoPresenter.RepoContractView, RepoListAdapter.OnItemClick {

    @Inject
    protected lateinit var repoPresenter: RepoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inject()
        setupReciclerView()
        initialize()
    }

    private fun inject() {
        val customApplication = application as CustomApplicationImpl
        customApplication.builder().inject(this)
        repoPresenter.contractView = this
    }

    private fun initialize() {
        repoPresenter.retrieve("java", "stars")
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

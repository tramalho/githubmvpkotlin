package br.com.tramalho.githubmvpkotlin.presentation

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.tramalho.githubmvpkotlin.R
import android.content.Intent
import br.com.tramalho.githubmvpkotlin.data.model.RepoModel
import br.com.tramalho.githubmvpkotlin.infraestructure.configActionBar
import kotlinx.android.synthetic.main.activity_pull_detail.*
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import br.com.tramalho.githubmvpkotlin.data.model.PullModel
import br.com.tramalho.githubmvpkotlin.infraestructure.CustomApplication
import br.com.tramalho.githubmvpkotlin.infraestructure.DataStatus
import br.com.tramalho.githubmvpkotlin.infraestructure.showShort
import br.com.tramalho.githubmvpkotlin.presentation.presenter.PullRequestPresenter
import javax.inject.Inject


class PullDetailActivity: AppCompatActivity(), PullRequestPresenter.PullContractView {

    companion object {

        private const val PULL_EXTRA  = "PULL_EXTRA"

        fun launchActivity(context: Context, repoModel: RepoModel) {
            val intent = Intent(context, PullDetailActivity::class.java)
            val extra = Bundle()
            extra.putParcelable(PullDetailActivity.PULL_EXTRA, repoModel)
            intent.putExtras(extra)
            context.startActivity(intent)
        }
    }

    private var repoModel: RepoModel? = null

    @Inject
    protected lateinit  var pullRequestPresenter: PullRequestPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_detail)
        inject()
        extractIntentData(savedInstanceState)
        configActionBar(repoModel?.name)
        setupRecyclerView()
        initialize()
    }

    private fun inject() {
        val customApplication = application as CustomApplication
        customApplication.builder().inject(this)
        pullRequestPresenter.contractView = this
    }

    private fun initialize() {
        pullRequestPresenter.retrieve(repoModel!!)
    }

    private fun setupRecyclerView() {
        pullRecyclerView.layoutManager = LinearLayoutManager(this)
        pullRecyclerView.adapter = PullListAdapter(mutableListOf())
    }

    private fun extractIntentData(savedInstanceState: Bundle?){

        repoModel  = intent?.getParcelableExtra(PULL_EXTRA)

        if (savedInstanceState != null) {
            repoModel = savedInstanceState.getParcelable(PULL_EXTRA)
        }
    }

    private fun updateVisibility(status: DataStatus) {

        var showItem = View.VISIBLE
        var repoRV = View.GONE

        if (status.equals(DataStatus.HAS_ITENS)) {
            showItem = View.GONE
            repoRV = View.VISIBLE
        }

        showPullProgressBar.visibility = showItem
        pullRecyclerView.visibility = repoRV
    }

    override fun onSuccess(result: List<PullModel>) {
        val adapter = pullRecyclerView.adapter as PullListAdapter
        adapter.updateItens(result)
        updateVisibility(DataStatus.HAS_ITENS)

    }

    override fun onError() {
        showShort("Erro")
    }
}

package br.com.tramalho.githubmvpkotlin.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.tramalho.githubmvpkotlin.R

/**
 * Created by trama on 23/03/18.
 */
class RepoListAdapter(itens: List<String>) : RecyclerView.Adapter<RepoViewHolder>() {

    val itens = itens


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RepoViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)

        return RepoViewHolder(layoutInflater.inflate(R.layout.item_repo, parent, false))
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder?, position: Int) {

    }

}

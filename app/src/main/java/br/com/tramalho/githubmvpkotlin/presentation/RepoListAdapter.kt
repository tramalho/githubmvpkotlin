package br.com.tramalho.githubmvpkotlin.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.tramalho.githubmvpkotlin.R
import br.com.tramalho.githubmvpkotlin.data.model.RepoModel

/**
 * Created by trama on 23/03/18.
 */
class RepoListAdapter(private val itens: MutableList<RepoModel>) : RecyclerView.Adapter<RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RepoViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)

        return RepoViewHolder(layoutInflater.inflate(R.layout.item_repo, parent, false))
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repoModel = this.itens[position]
        holder.bind(repoModel)
    }

    fun updateItens(repoModel: List<RepoModel>) : Unit {
        itens.addAll(repoModel)
        notifyDataSetChanged()
    }
}



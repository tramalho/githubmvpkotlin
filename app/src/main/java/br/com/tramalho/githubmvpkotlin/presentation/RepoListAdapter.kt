package br.com.tramalho.githubmvpkotlin.presentation

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import br.com.tramalho.githubmvpkotlin.R
import br.com.tramalho.githubmvpkotlin.data.model.RepoModel
import br.com.tramalho.githubmvpkotlin.infraestructure.inflateLayoutRow

/**
 * Created by trama on 23/03/18.
 */
class RepoListAdapter(private val itens: MutableList<RepoModel>, var onItemClick: OnItemClick?) : RecyclerView.Adapter<RepoViewHolder>() {

    interface OnItemClick{
        fun onClick(repoEntity: RepoModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val layoutRow = inflateLayoutRow(parent, R.layout.item_repo)

        return RepoViewHolder(layoutRow, onItemClick)
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repoModel = this.itens[position]
        holder.bind(repoModel)
    }

    fun updateItens(repoModel: List<RepoModel>) {
        itens.addAll(repoModel)
        notifyDataSetChanged()
    }
}



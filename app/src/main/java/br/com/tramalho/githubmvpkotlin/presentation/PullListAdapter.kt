package br.com.tramalho.githubmvpkotlin.presentation

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import br.com.tramalho.githubmvpkotlin.R
import br.com.tramalho.githubmvpkotlin.data.model.PullModel
import br.com.tramalho.githubmvpkotlin.infraestructure.inflateLayoutRow

class PullListAdapter(val itens : MutableList<PullModel>) : RecyclerView.Adapter<PullViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullViewHolder {

        val layoutRow = inflateLayoutRow(parent, R.layout.item_pull)

        return PullViewHolder(layoutRow)
    }

    override fun onBindViewHolder(holder: PullViewHolder, position: Int) {
        holder.bind(itens[position])
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    fun updateItens(result: List<PullModel>) {
        itens.addAll(result)
        notifyDataSetChanged()
    }

}

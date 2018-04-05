package br.com.tramalho.githubmvpkotlin.presentation

import android.support.v7.widget.RecyclerView
import android.view.View
import br.com.tramalho.githubmvpkotlin.data.model.RepoModel
import kotlinx.android.synthetic.main.item_repo.view.*


class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(repoEntity: RepoModel) {
        itemView.name.text = repoEntity.name
        itemView.fullName.text = repoEntity.fullName
        itemView.fork_size.text = repoEntity.forksCount.toString()
        itemView.star_size.text = repoEntity.stargazersCount.toString()
        //itemView.user_nick.text = repoEntity.u
    }
}

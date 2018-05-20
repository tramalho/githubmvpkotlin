package br.com.tramalho.githubmvpkotlin.presentation

import android.support.v7.widget.RecyclerView
import android.view.View
import br.com.tramalho.githubmvpkotlin.data.model.RepoModel
import kotlinx.android.synthetic.main.item_repo.view.*


class RepoViewHolder(itemView: View?, val onItemClick: RepoListAdapter.OnItemClick?) : RecyclerView.ViewHolder(itemView) {

    fun bind(repoEntity: RepoModel) {

        with(itemView) {
            name.text = repoEntity.name
            fullName.text = repoEntity.fullName
            fork_size.text = repoEntity.forksCount.toString()
            star_size.text = repoEntity.stargazersCount.toString()
            user_nick.text = repoEntity.repoOwner?.login

            setOnClickListener {
                onItemClick?.onClick(repoEntity)
            }
        }
    }
}

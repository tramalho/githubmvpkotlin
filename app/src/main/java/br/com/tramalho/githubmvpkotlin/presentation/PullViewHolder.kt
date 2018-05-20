package br.com.tramalho.githubmvpkotlin.presentation

import android.support.v7.widget.RecyclerView
import android.view.View
import br.com.tramalho.githubmvpkotlin.data.model.PullModel
import br.com.tramalho.githubmvpkotlin.infraestructure.loadFromRemote
import kotlinx.android.synthetic.main.item_pull.view.*

class PullViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun bind(pullModel: PullModel) {

        with(itemView) {
            pull_name_id.text = pullModel.title
            pull_description_id.text = pullModel.body
            pull_date_id.text = pullModel.createdAt
            pull_user_avatar_id.loadFromRemote(pullModel.user.avatarUrl)
        }
    }
}

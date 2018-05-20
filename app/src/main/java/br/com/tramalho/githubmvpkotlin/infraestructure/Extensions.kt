package br.com.tramalho.githubmvpkotlin.infraestructure

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import br.com.tramalho.githubmvpkotlin.R
import com.bumptech.glide.Glide

/**
 * Created by trama on 04/04/18.
 */
fun Activity.showShort(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.configActionBar(title: String?) {
    val supportActionBar = this.supportActionBar
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setTitle(title)
}

fun <T : RecyclerView.ViewHolder?> RecyclerView.Adapter<T>.inflateLayoutRow(parent: ViewGroup?, rIdLayout: Int): View? {

    val layoutInflater = LayoutInflater.from(parent?.context)

    return layoutInflater.inflate(rIdLayout, parent, false);

}

fun ImageView.loadFromRemote(url: String, rIdError: Int = R.drawable.ic_account_circle_black_24px) {

   if (!TextUtils.isEmpty(url)) {

        Glide.with(context)
                .load(url)
                .into(this);
    } else {
        setImageResource(rIdError);
    }
}


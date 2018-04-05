package br.com.tramalho.githubmvpkotlin.presentation.utils

import android.app.Activity
import android.content.Context
import android.widget.Toast

/**
 * Created by trama on 04/04/18.
 */
fun Activity.showShort(ctx: Context, text: String){
    Toast.makeText(ctx, text, Toast.LENGTH_SHORT).show()
}
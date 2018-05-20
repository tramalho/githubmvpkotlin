package br.com.tramalho.githubmvpkotlin.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by trama on 18/05/18.
 */
@Parcelize
data class RepoOwner(
        @SerializedName("login")
        val login:String = ""
) : Parcelable

package com.waterseven.macro.lestari.model.article

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val id: Int,
    val title: String,
    val content: String,
    val publisher: String,
    val datePublish: String,
    val imageUrl: String
) : Parcelable

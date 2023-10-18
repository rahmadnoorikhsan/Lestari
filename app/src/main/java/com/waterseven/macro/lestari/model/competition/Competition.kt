package com.waterseven.macro.lestari.model.competition

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Competition(
    val id: Int,
    val title: String,
    val image: String,
    val date: String,
    val description: String,
    val location: String,
    val actor: String,
    val time: String
):Parcelable

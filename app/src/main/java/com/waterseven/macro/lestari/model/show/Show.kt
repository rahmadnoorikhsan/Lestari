package com.waterseven.macro.lestari.model.show

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Show(
    val id: Int,
    val title: String,
    val image: String,
    val date: String,
    val description: String,
    val location: String,
    val actor: String,
    val time: String
):Parcelable

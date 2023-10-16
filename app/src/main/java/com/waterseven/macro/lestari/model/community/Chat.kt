package com.waterseven.macro.lestari.model.community

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chat(
    val name: String,
    val message: String,
    val time: String,
    val image: String
):Parcelable

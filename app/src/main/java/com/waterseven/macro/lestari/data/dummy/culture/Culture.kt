package com.waterseven.macro.lestari.data.dummy.culture

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Culture(
    val id: Int,
    val title: String,
    val place: String,
    val description: String,
    val imageCover: String,
    val imageAsset: List<String>,
    val video: String
): Parcelable

package com.waterseven.macro.lestari.model.culture

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Culture(
    val id: Int,
    val title: String,
    val place: String,
    val description: String,
    val imageCover: String,
    val imageAsset: List<ImageCulture>,
    val video: String
): Parcelable

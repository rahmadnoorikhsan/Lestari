package com.waterseven.macro.lestari.model.culture

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageCulture(
    val id: Int,
    val url: String
): Parcelable

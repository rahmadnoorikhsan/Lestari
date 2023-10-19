package com.waterseven.macro.lestari.model.museum

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Museum(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val creator: String,
    val year: Int
) : Parcelable

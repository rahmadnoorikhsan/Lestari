package com.waterseven.macro.lestari.model.community

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrainingCommunity(
    val id: Int,
    val name: String
):Parcelable

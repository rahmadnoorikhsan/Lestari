package com.waterseven.macro.lestari.model.community

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrainingSchedule(
    val date: String,
    val title : String,
    val time : String
):Parcelable

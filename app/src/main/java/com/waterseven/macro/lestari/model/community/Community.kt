package com.waterseven.macro.lestari.model.community

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Community(
    val image: String,
    val name: String,
    val desc : String,
    val location : String,
    val forum: List<ForumCommunity>,
    val trainings: List<TrainingCommunity>,
    val history: String,
    var join : Boolean,
    val members: Int
):Parcelable

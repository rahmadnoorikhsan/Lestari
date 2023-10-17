package com.waterseven.macro.lestari.model.community

import android.os.Parcelable
import com.waterseven.macro.lestari.data.community.CommunityForum
import com.waterseven.macro.lestari.data.community.CommunityTraining
import kotlinx.parcelize.Parcelize

@Parcelize
data class Community(
    val image: String = "",
    val name: String = "",
    val desc: String = "",
    val location: String = "",
    val forum: MutableList<ForumCommunity> = CommunityForum.dummyCommunityForum,
    val trainings: List<TrainingCommunity> = CommunityTraining.dummyCommunityTraining,
    val history: String = "",
    var join: Boolean = false,
    val members: Int = 0
):Parcelable

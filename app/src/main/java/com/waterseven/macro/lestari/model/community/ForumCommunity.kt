package com.waterseven.macro.lestari.model.community

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForumCommunity(
    val id : Int,
    val name : String,
    val chats : List<Chat>
):Parcelable

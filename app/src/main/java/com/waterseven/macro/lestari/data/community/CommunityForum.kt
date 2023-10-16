package com.waterseven.macro.lestari.data.community

import com.waterseven.macro.lestari.model.community.Chat
import com.waterseven.macro.lestari.model.community.ForumCommunity

object CommunityForum {
    val dummyCommunityForum = listOf<ForumCommunity>(
        ForumCommunity(
            id = 1,
            name = "Tari",
            chats = CommunityChat.dummyCommunityChat
        )
    )


}
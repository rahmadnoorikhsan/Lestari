package com.waterseven.macro.lestari.presentation.community.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.presentation.community.fragment.detail.CommunityForum
import com.waterseven.macro.lestari.presentation.community.fragment.detail.CommunityInfo
import com.waterseven.macro.lestari.presentation.community.fragment.detail.TrainingFragment

class SectionsCommunityPagerAdapter(activity: FragmentActivity, private val community: Community) : FragmentStateAdapter(activity) {
    override fun getItemCount() = 3
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = CommunityInfo(community)
            1 -> fragment = CommunityForum(community)
            2 -> fragment = TrainingFragment(community)
        }

        return fragment as Fragment
    }
}
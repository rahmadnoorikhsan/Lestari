package com.waterseven.macro.lestari.presentation.community.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.presentation.community.fragment.detail.CommunityForum
import com.waterseven.macro.lestari.presentation.community.fragment.detail.CommunityInfo

class SectionCommunityPagerAdapter(fragment: FragmentActivity, private val community: Community?) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val fragment : Fragment? = null
        val bundle = Bundle()
        bundle.putParcelable("community", community)
        when(position) {
            0 -> {
                val fragment = CommunityInfo()
                fragment.arguments = bundle
                fragment
            }
            1 -> {
                val fragment = CommunityForum()
                fragment.arguments = bundle
                fragment
            }
            else -> throw IndexOutOfBoundsException("Invalid position $position requested")
        }
        return fragment as Fragment
    }

}
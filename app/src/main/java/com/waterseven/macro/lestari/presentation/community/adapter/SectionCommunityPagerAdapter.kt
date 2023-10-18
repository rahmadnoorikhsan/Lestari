package com.waterseven.macro.lestari.presentation.community.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.presentation.community.CommunityForum
import com.waterseven.macro.lestari.presentation.community.CommunityInfo
import com.waterseven.macro.lestari.presentation.home.information.event.competition.CompetitionFragment
import com.waterseven.macro.lestari.presentation.home.information.event.show.ShowFragment

class SectionCommunityPagerAdapter(activity: AppCompatActivity, private val community: Community?) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        fun data(): Bundle {
            val bundle = Bundle()
            bundle.putParcelable("community", community)
            return bundle
        }
        var fragment: Fragment? = null
        when(position) {
            0 -> {
                fragment = CommunityInfo()
                fragment.arguments = data()
                fragment
            }
            1 -> {
                fragment = CommunityForum()
                fragment.arguments = data()
                fragment
            }
        }

        return fragment as Fragment
    }

}
package com.waterseven.macro.lestari.presentation.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.waterseven.macro.lestari.presentation.home.information.event.competition.CompetitionFragment
import com.waterseven.macro.lestari.presentation.home.information.event.show.ShowFragment

class SectionsEventPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = ShowFragment()
            1 -> fragment = CompetitionFragment()
        }

        return fragment as Fragment
    }
}

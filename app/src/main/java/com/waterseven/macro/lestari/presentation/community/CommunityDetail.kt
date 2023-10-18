package com.waterseven.macro.lestari.presentation.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.ActivityCommunityDetailBinding
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.presentation.community.adapter.SectionCommunityPagerAdapter
import com.waterseven.macro.lestari.presentation.home.adapter.SectionsEventPagerAdapter
import com.waterseven.macro.lestari.presentation.home.information.event.EventFragment

class CommunityDetail : AppCompatActivity() {
    private lateinit var tabs : TabLayout
    private lateinit var binding: ActivityCommunityDetailBinding
    private lateinit var community: Community

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        community = intent.getParcelableExtra<Community>("community")!!

        community?.image?.toIntOrNull()?.let { binding.logo.setImageResource(it) }
        binding.namaKomunitas.setText(community?.name)
        binding.totalMember.setText("${community?.members.toString()} Anggota")

        setUpViewPager()

        binding.arrowBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setUpViewPager() {

        val sectionsCommunityPagerAdapter = SectionCommunityPagerAdapter(this,community)

        binding?.apply {
            viewPagerDetailCommunity.adapter = sectionsCommunityPagerAdapter

            TabLayoutMediator(tabs, viewPagerDetailCommunity) { tab, position ->
                tab.icon = resources.getDrawable(TAB_TITLES[position])
            }.attach()
        }
    }

    companion object {
        @DrawableRes
        private val TAB_TITLES = intArrayOf(
            R.drawable.ic_info,
            R.drawable.ic_forum,
            R.drawable.ic_pelatihan
        )
    }

}
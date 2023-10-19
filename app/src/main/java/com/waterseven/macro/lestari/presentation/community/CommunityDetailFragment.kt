package com.waterseven.macro.lestari.presentation.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.FragmentCommunityDetailBinding
import com.waterseven.macro.lestari.presentation.community.adapter.SectionsCommunityPagerAdapter

class CommunityDetailFragment : Fragment() {
    private var _binding : FragmentCommunityDetailBinding? = null
    private val binding get() = _binding
    private val navArgs: CommunityDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentCommunityDetailBinding.inflate(layoutInflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewPager()
        backButton()
    }
    private fun backButton(){
        binding?.arrowBack?.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setUpViewPager() {
        val community = navArgs.community
        val sectionsCommunityPagerAdapter = SectionsCommunityPagerAdapter(requireActivity(),community )

        binding?.apply {
            contentDetail.viewPagerDetailCommunity.adapter = sectionsCommunityPagerAdapter

            TabLayoutMediator(contentDetail.tabs, contentDetail.viewPagerDetailCommunity) { tab, position ->
                tab.icon = resources.getDrawable(TAB_TITLES[position])
            }.attach()
        }
    }


    companion object {
        @DrawableRes
        private val TAB_TITLES = intArrayOf(
            R.drawable.ic_info,
            R.drawable.ic_forum,
            R.drawable.ic_pelatihan,
        )
    }


}
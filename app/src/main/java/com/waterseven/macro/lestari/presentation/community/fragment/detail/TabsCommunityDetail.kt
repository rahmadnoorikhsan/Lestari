package com.waterseven.macro.lestari.presentation.community.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.FragmentTabsCommunityDetailBinding
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.presentation.community.adapter.SectionCommunityPagerAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TabsCommunityDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabsCommunityDetail : Fragment() {
    private lateinit var binding : FragmentTabsCommunityDetailBinding
    private lateinit var community : Community

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentTabsCommunityDetailBinding.inflate(layoutInflater)
       return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewPager()
    }
    private fun setUpViewPager() {
        community = arguments?.getParcelable<Community>("community")!!
        val sectionsCommunityPagerAdapter = SectionCommunityPagerAdapter(requireActivity(),community)

        binding.apply {
            viewPagerDetailCommunity.adapter = sectionsCommunityPagerAdapter

            TabLayoutMediator(tabs, viewPagerDetailCommunity) { tab, position ->
                tab.icon = requireContext().resources.getDrawable(TAB_TITLES[position])
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
package com.waterseven.macro.lestari.presentation.community.fragment.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.data.community.CommunityData
import com.waterseven.macro.lestari.presentation.community.adapter.RvCommunityAdapter
import com.waterseven.macro.lestari.databinding.FragmentMyCommunityBinding
import com.waterseven.macro.lestari.presentation.community.CommunityFragmentDirections

class MyCommunity : Fragment() {
    private lateinit var binding: FragmentMyCommunityBinding
    private lateinit var communityAdapter: RvCommunityAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyCommunityBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }
    private fun setUpView() {
        //mengambil data dari data model dummy
        val communityData = CommunityData.dummyCommunity.filter {
            it.join == true
        }

        communityAdapter = RvCommunityAdapter { community ->
            val data =
                CommunityFragmentDirections.actionCommunityFragmentToCommunityDetailFragment(community)

            findNavController().navigate(data)
        }

        binding?.rvMyCommunity?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = communityAdapter
        }
        communityAdapter.submitList(communityData)

    }



}
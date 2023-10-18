package com.waterseven.macro.lestari.presentation.community.fragment.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.data.community.CommunityData
import com.waterseven.macro.lestari.databinding.FragmentCommunitySharingBinding
import com.waterseven.macro.lestari.presentation.community.CommunityFragmentDirections
import com.waterseven.macro.lestari.presentation.community.adapter.RvCommunitySharingAdapter


class CommunitySharing : Fragment() {
    private lateinit var binding: FragmentCommunitySharingBinding
    private lateinit var communitySharingAdapter: RvCommunitySharingAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommunitySharingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView(){
        //mengambil data dari data model dummy
        val communityData = CommunityData.dummyCommunity.filter {
            it.join == false
        }
        //menampilkan komunitas dengan status join false

        communitySharingAdapter = RvCommunitySharingAdapter { community ->
            val data = CommunityFragmentDirections.actionCommunityFragmentToCommunitySharing(
                communityData.toTypedArray()
            )
            findNavController().navigate(data)
        }

        binding?.rvCommunitySharing?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = communitySharingAdapter
        }

        communitySharingAdapter.submitList(communityData)
    }
}
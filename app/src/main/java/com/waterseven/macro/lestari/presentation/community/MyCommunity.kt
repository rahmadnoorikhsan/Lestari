package com.waterseven.macro.lestari.presentation.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.data.community.CommunityData
import com.waterseven.macro.lestari.databinding.FragmentMyCommunityBinding
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.presentation.community.adapter.RvCommunityAdapter

class MyCommunity : Fragment() {
    private var _binding: FragmentMyCommunityBinding? = null
    private val binding get() = _binding
    private lateinit var communityAdapter: RvCommunityAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyCommunityBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        val communityData = CommunityData.dummyCommunity

        communityAdapter = RvCommunityAdapter { community ->
            val data = CommunityFragmentDirections.actionCommunityFragmentToMyCommunity2(community)
            findNavController().navigate(data)
        }

        binding?.rvMyCommunity?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = communityAdapter
        }

        val communityHasJoin : MutableList<Community> = mutableListOf()

       communityData.forEach{
           if(it.join){
                communityHasJoin.add(it)
           }
       }
        communityAdapter.submitList(communityHasJoin)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
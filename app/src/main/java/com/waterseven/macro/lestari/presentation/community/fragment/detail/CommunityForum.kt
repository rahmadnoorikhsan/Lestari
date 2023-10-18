package com.waterseven.macro.lestari.presentation.community.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.data.community.CommunityData
import com.waterseven.macro.lestari.data.community.CommunityForum
import com.waterseven.macro.lestari.databinding.FragmentCommunityForumBinding
import com.waterseven.macro.lestari.databinding.FragmentCommunityInfo2Binding
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.presentation.community.adapter.RvCommunityAdapter
import com.waterseven.macro.lestari.presentation.community.adapter.RvCommunityForumAdapter

class CommunityForum(private val community: Community) : Fragment() {
    private var _binding: FragmentCommunityForumBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvCommunityForumAdapter: RvCommunityForumAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCommunityForumBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView(){
        rvCommunityForumAdapter = RvCommunityForumAdapter()
        binding?.rvCommunityForum?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = rvCommunityForumAdapter
        }
        rvCommunityForumAdapter.submitList(community.forum)
    }



}
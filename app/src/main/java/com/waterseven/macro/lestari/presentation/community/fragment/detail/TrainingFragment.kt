package com.waterseven.macro.lestari.presentation.community.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.FragmentCommunityForumBinding
import com.waterseven.macro.lestari.databinding.FragmentTrainingBinding
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.presentation.community.adapter.RvCommunityForumAdapter
import com.waterseven.macro.lestari.presentation.community.adapter.RvCommunityTrainingBinding

class TrainingFragment(private val community: Community) : Fragment() {
    private var _binding: FragmentTrainingBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvCommunityTrainingAdapter: RvCommunityTrainingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrainingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView(){
        rvCommunityTrainingAdapter = RvCommunityTrainingBinding()
        binding?.rvCommunityTraining?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = rvCommunityTrainingAdapter
        }
        rvCommunityTrainingAdapter.submitList(community.forum)
    }
}
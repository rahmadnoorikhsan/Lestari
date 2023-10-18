package com.waterseven.macro.lestari.presentation.community.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.data.community.CommunityData
import com.waterseven.macro.lestari.databinding.FragmentCommunityInfo2Binding
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.presentation.community.CommunityDetailFragmentArgs
import com.waterseven.macro.lestari.presentation.community.CommunityFragmentDirections
import com.waterseven.macro.lestari.presentation.community.adapter.RvCommunitySharingAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [CommunityInfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommunityInfo(private val community: Community): Fragment() {
    private var _binding: FragmentCommunityInfo2Binding? = null
    private val binding get() = _binding

    private val navArgs: CommunityDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCommunityInfo2Binding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.lokasi?.setText(community.location)
        binding?.latihan?.setText(community.trainings.map{it.name}.joinToString())
        binding?.sejarah?.setText(community.history)
    }
}
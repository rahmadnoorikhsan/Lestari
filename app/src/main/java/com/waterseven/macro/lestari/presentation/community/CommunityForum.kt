package com.waterseven.macro.lestari.presentation.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.FragmentCommunityForumBinding
import com.waterseven.macro.lestari.databinding.FragmentCommunityInfo2Binding
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.presentation.community.adapter.RvCommunityForumAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [CommunityForum.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommunityForum : Fragment() {
    private var _binding: FragmentCommunityForumBinding? = null
    private val binding get() = _binding!!
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
        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvCommunityForum.layoutManager = layoutManager
        setUpView()
    }

    private fun setUpView() {
        val data = arguments?.getParcelable<Community>("community")
        if(data!= null){
            binding.namakomunitas
            binding.rvCommunityForum
        }
    }


}
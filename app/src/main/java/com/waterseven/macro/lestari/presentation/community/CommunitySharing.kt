package com.waterseven.macro.lestari.presentation.community

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.data.community.CommunityData
import com.waterseven.macro.lestari.databinding.FragmentCommunitySharingBinding
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.presentation.community.adapter.RvCommunitySharingAdapter


class CommunitySharing : Fragment() {
    private lateinit var binding: FragmentCommunitySharingBinding
    private lateinit var communitySharingAdapter: RvCommunitySharingAdapter
    //mengambil data dari data model dummy
    private val communityData = CommunityData.dummyCommunity
    private val communityHasJoin : MutableList<Community> = mutableListOf()

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
        //menampilkan komunitas dengan status join false
        communityData.forEach{
            if(it.join == false){
                communityHasJoin.add(it)
            }
        }
        communitySharingAdapter = RvCommunitySharingAdapter { community ->
            val data = CommunityFragmentDirections.actionCommunityFragmentToCommunitySharing(
                communityHasJoin.toTypedArray()
            )
            findNavController().navigate(data)
        }

        binding?.rvCommunitySharing?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = communitySharingAdapter
        }

        communitySharingAdapter.submitList(communityHasJoin)
    }

//    private fun searchCommunity(){
//        val searchView: SearchView = binding.search
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                // Lakukan pencarian data berdasarkan query yang dimasukkan pengguna
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                // Lakukan aksi saat teks pencarian berubah
//                // Misalnya, lakukan filtering pada data yang ditampilkan di RecyclerView berdasarkan newText
//                if(communityHasJoin.forEachIndexed(){ k,v ->
//                    if(k.)
//                    }
//                return false
//            }
//        })
//
//    }



}
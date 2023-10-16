package com.waterseven.macro.lestari.presentation.community

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.adapter.RvCommunityAdapter
import com.waterseven.macro.lestari.databinding.FragmentCommunitySharingBinding
import com.waterseven.macro.lestari.model.community.komunitas

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CommunitySharing.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommunitySharing : Fragment() {
    private lateinit var binding: FragmentCommunitySharingBinding
    private lateinit var adapterKeren: RvCommunityAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCommunitySharingBinding.inflate(layoutInflater)
        return binding.root
        return inflater.inflate(R.layout.fragment_community_sharing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setRvAdapter()
    }
    private fun nama_komunitas(): Array<String> = requireContext().resources.getStringArray(R.array.cari_nama_komunitas)
    private fun deskripsi_komunitas(): Array<String> = requireContext().resources.getStringArray(R.array.cari_deskripsi_komunitas)

    private fun imageWisata(): List<Int> = listOf(
        R.drawable.gedong_kuning,
        R.drawable.bengkel_seni,
        R.drawable.semarak
    )

    val dataList: MutableList<komunitas> = mutableListOf()

    private fun init() {
        adapterKeren = RvCommunityAdapter(dataList)
        binding.rvCommunitySharing.layoutManager = LinearLayoutManager(requireContext()) // Mengatur layout manager
        binding.rvCommunitySharing.adapter = adapterKeren // Menghubungkan adapter ke RecyclerView
    }

    private fun setRvAdapter() {

        val dataList:MutableList<komunitas> = mutableListOf()

        nama_komunitas().forEachIndexed { index, name ->
            dataList.add(komunitas(imageWisata().get(index),name,deskripsi_komunitas().get(index),"","","" ))
        }

        Log.d("ISI DATANYA ",dataList.toString())
        adapterKeren = RvCommunityAdapter(dataList)
        binding.rvCommunitySharing.adapter = adapterKeren

    }

}
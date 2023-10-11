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
import com.waterseven.macro.lestari.databinding.FragmentMyCommunityBinding
import com.waterseven.macro.lestari.model.community.komunitas

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyCommunity.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyCommunity : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentMyCommunityBinding
    private lateinit var adapterKeren: RvCommunityAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyCommunityBinding.inflate(layoutInflater)
        return binding.root
        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setRvAdapter()
    }
    private fun nama_komunitas(): Array<String> = requireContext().resources.getStringArray(R.array.nama_komunitas)
    private fun deskripsi_komunitas(): Array<String> = requireContext().resources.getStringArray(R.array.deskripsi_komunitas)

    private fun imageWisata(): List<Int> = listOf(
        R.drawable.komunitas1
    )

    val dataList: MutableList<komunitas> = mutableListOf()

    private fun init() {
        adapterKeren = RvCommunityAdapter(dataList)
        binding.rvMyCommunity.layoutManager = LinearLayoutManager(requireContext()) // Mengatur layout manager
        binding.rvMyCommunity.adapter = adapterKeren // Menghubungkan adapter ke RecyclerView
    }

    private fun setRvAdapter() {

        val dataList:MutableList<komunitas> = mutableListOf()

        nama_komunitas().forEachIndexed { index, name ->
            dataList.add(komunitas(imageWisata().get(index),name,deskripsi_komunitas().get(index),"","","" ))
        }

        Log.d("ISI DATANYA ",dataList.toString())
        adapterKeren = RvCommunityAdapter(dataList)
        binding.rvMyCommunity.adapter = adapterKeren

    }



}
package com.waterseven.macro.lestari.presentation.home.information.event.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.data.show.ShowData
import com.waterseven.macro.lestari.databinding.FragmentShowBinding
import com.waterseven.macro.lestari.presentation.home.adapter.ShowAdapter
import com.waterseven.macro.lestari.presentation.home.information.event.EventFragmentDirections

class ShowFragment : Fragment() {

    private var _binding: FragmentShowBinding? = null
    private val binding get() = _binding
    private lateinit var showAdapter: ShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycleView()
    }




    private fun setUpRecycleView() {
        val showData = ShowData.dummyShow
        showAdapter = ShowAdapter {show ->
            val action = EventFragmentDirections.actionEventFragmentToDetailShowFragment(show)
            findNavController().navigate(action)
        }

        binding?.rvShow?.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            adapter = showAdapter
        }
        showAdapter.submitList(showData)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
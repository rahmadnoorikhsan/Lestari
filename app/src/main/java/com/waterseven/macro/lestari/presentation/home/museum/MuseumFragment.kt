package com.waterseven.macro.lestari.presentation.home.museum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.data.museum.MuseumsData
import com.waterseven.macro.lestari.databinding.FragmentMuseumBinding
import com.waterseven.macro.lestari.model.museum.Museum
import com.waterseven.macro.lestari.presentation.home.adapter.MuseumAdapter

class MuseumFragment : Fragment() {

    private var _binding: FragmentMuseumBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMuseumBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showListMuseum()
    }

    private fun showListMuseum() {
        val museumsData = MuseumsData.museumDummy

        val adapters = MuseumAdapter { museum ->
            navigateToDetail(museum)
        }

        binding?.rvMuseum?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = adapters
        }
        adapters.submitList(museumsData)
    }

    private fun navigateToDetail(museum: Museum) {
        val data = MuseumFragmentDirections.actionMuseumFragmentToDialogMuseumFragment(museum)
        findNavController().navigate(data)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
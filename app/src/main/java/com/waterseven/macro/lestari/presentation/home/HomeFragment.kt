package com.waterseven.macro.lestari.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.model.culture.Culture
import com.waterseven.macro.lestari.data.culture.CulturesData
import com.waterseven.macro.lestari.databinding.FragmentHomeBinding
import com.waterseven.macro.lestari.presentation.home.adapter.CultureAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showListCulture()
        navigateToCulture()
        navigateToMuseum()
    }

    private fun navigateToMuseum() {
        val action = HomeFragmentDirections.actionHomeFragmentToMuseumFragment()

        binding?.contentHome?.museumCard?.apply {
            btnExplore.setOnClickListener {
                findNavController().navigate(action)
            }
        }
    }

    private fun showListCulture() {
        val cultureData = CulturesData.dummyCultures

        val adapter = CultureAdapter { culture ->
            navigateToDetailCulture(culture)
        }

        binding?.contentHome?.apply {
            rvCulture.layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false
            )
            rvCulture.adapter = adapter
            adapter.submitList(cultureData)
        }
    }

    private fun navigateToCulture() {
        val action = HomeFragmentDirections.actionHomeFragmentToCultureFragment()

        binding?.contentHome?.tvCulture?.setOnClickListener {
            findNavController().navigate(action)
        }
    }

    private fun navigateToDetailCulture(culture: Culture) {
        val data = HomeFragmentDirections.actionHomeFragmentToCultureDetailActivity(culture)
        findNavController().navigate(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
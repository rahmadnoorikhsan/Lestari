package com.waterseven.macro.lestari.presentation.home.information.event.competition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.data.competition.CompetitionData
import com.waterseven.macro.lestari.databinding.FragmentCompetitionBinding
import com.waterseven.macro.lestari.presentation.home.adapter.CompetitionAdapter
import com.waterseven.macro.lestari.presentation.home.information.event.EventFragmentDirections

class CompetitionFragment : Fragment() {

    private var _binding: FragmentCompetitionBinding? = null
    private val binding get() = _binding
    private lateinit var competitionAdapter: CompetitionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompetitionBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycleView()
    }

    private fun setUpRecycleView() {
        val competitionData = CompetitionData.dummyCompetition
        competitionAdapter = CompetitionAdapter { competition ->
            val action =
                EventFragmentDirections.actionEventFragmentToDetailCompetitionFragment(competition)
            findNavController().navigate(action)
        }

        binding?.rvCompetition?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = competitionAdapter
        }
        competitionAdapter.submitList(competitionData)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
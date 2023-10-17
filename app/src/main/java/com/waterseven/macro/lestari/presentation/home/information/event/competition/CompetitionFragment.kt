package com.waterseven.macro.lestari.presentation.home.information.event.competition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.waterseven.macro.lestari.databinding.FragmentCompetitionBinding

class CompetitionFragment : Fragment() {

    private var _binding: FragmentCompetitionBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompetitionBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }
}
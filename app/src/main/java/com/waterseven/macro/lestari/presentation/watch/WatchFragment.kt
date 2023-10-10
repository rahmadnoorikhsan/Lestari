package com.waterseven.macro.lestari.presentation.watch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.waterseven.macro.lestari.databinding.FragmentWatchBinding

class WatchFragment : Fragment() {

    private var _binding: FragmentWatchBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWatchBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }
}
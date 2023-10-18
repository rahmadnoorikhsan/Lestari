package com.waterseven.macro.lestari.presentation.home.information.event.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.waterseven.macro.lestari.databinding.FragmentShowBinding

class ShowFragment : Fragment() {

    private var _binding: FragmentShowBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
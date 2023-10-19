package com.waterseven.macro.lestari.presentation.watch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.waterseven.macro.lestari.data.watch.WatchData
import com.waterseven.macro.lestari.databinding.FragmentWatchBinding
import com.waterseven.macro.lestari.presentation.watch.adapter.WatchAdapter

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
    }

    private fun setUpView() {
        val watch = WatchData.dummyWatch
        val watchAdapter = WatchAdapter()

        watchAdapter.submitList(watch)
        binding?.apply {
            viewPager.adapter = watchAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
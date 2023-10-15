package com.waterseven.macro.lestari.presentation.home.museum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.DialogMuseumBinding

class DialogMuseumFragment : DialogFragment() {

    private var _binding: DialogMuseumBinding? = null
    private val binding get() = _binding
    private val navArgs: DialogMuseumFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogMuseumBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showDetailMuseum()
    }

    private fun showDetailMuseum() {
        val museum = navArgs.museum

        binding?.apply {
            tvTitle.text = museum.name
            tvDescription.text = museum.description
            tvPublisher.text = getString(R.string.publisher, museum.creator, museum.year.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
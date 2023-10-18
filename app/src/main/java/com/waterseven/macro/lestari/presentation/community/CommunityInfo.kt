package com.waterseven.macro.lestari.presentation.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.FragmentCommunityInfo2Binding
import com.waterseven.macro.lestari.model.community.Community

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CommunityInfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommunityInfo : Fragment() {
    private var _binding: FragmentCommunityInfo2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCommunityInfo2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        val data = arguments?.getParcelable<Community>("community")
        val pelatihan = data?.trainings?.map { it.name }
        val dataPelatihan = pelatihan?.joinToString()
        binding.lokasi.setText(data?.location)
        binding.latihan.setText(dataPelatihan)
        binding.sejarah.setText(data?.history)
    }
}


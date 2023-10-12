package com.waterseven.macro.lestari.presentation.community

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.FragmentCommunityBinding
import androidx.core.content.ContextCompat

class CommunityFragment : Fragment() {

    private var _binding: FragmentCommunityBinding? = null
    private  val binding get() = _binding

    private lateinit var myCommunity: Button
    private lateinit var communitySharing: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommunityBinding.inflate(layoutInflater, container, false)
        myCommunity = _binding?.myCommunity!!
        communitySharing = _binding?.communitySharing!!

        // Menandai tombol yang akan diaktifkan secara otomatis
        myCommunity.isSelected = true
        communitySharing.isSelected = false

        // Panggil fungsi untuk menampilkan fragment yang sesuai
        if (myCommunity.isSelected) {
            komunitasSaya()
        } else {
            cariKomunitas()
        }

        myCommunity.setOnClickListener {
            komunitasSaya()
            myCommunity.isSelected = true
            communitySharing.isSelected = false
        }
        communitySharing.setOnClickListener {
            cariKomunitas()
            myCommunity.isSelected = false
            communitySharing.isSelected = true
        }

        myCommunity.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.bg_text_community))
        communitySharing.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.bg_text_community))

        return binding?.root
    }

    private fun komunitasSaya( ) {
        val hasilFragment = MyCommunity() // Ganti dengan fragment yang sesuai
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.communityFragmentContainer, hasilFragment)
        transaction.commit()
    }

    private fun cariKomunitas( ) {
        val hasilFragment = CommunitySharing() // Ganti dengan fragment yang sesuai
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.communityFragmentContainer, hasilFragment)
        transaction.commit()
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.waterseven.macro.lestari.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.waterseven.macro.lestari.databinding.FragmentProfileBinding
import com.waterseven.macro.lestari.presentation.auth.SignInActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            tvMyProfile.setOnClickListener{
                moveToMyProfile()
            }
            tvPrivation.setOnClickListener{
                moveToCallService()
            }
            tvSetting.setOnClickListener{
                moveToSetting()
            }
            btnLogout.setOnClickListener {
                moveToLogin()
            }
        }
    }

    private fun moveToLogin() {
        val intent = Intent(requireActivity(), SignInActivity::class.java)
        startActivity(intent)
    }

    private fun moveToCallService() {
        val interaction = ProfileFragmentDirections.actionProfileFragmentToPrivacyFragment()
        findNavController()
            .navigate(interaction)    }

    private fun moveToSetting() {
        val interaction = ProfileFragmentDirections.actionProfileFragmentToSettingFragment()
        findNavController().navigate(interaction)
    }

    private fun moveToMyProfile() {
        val interaction = ProfileFragmentDirections.actionProfileFragmentToMyProfileFragment()
        findNavController().navigate(interaction)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
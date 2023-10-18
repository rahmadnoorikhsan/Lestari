package com.waterseven.macro.lestari.presentation.community.fragment.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.ActivityCommunityDetailBinding
import com.waterseven.macro.lestari.model.community.Community

class CommunityDetail : AppCompatActivity() {
    private lateinit var binding: ActivityCommunityDetailBinding
    private lateinit var community: Community

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        community = intent.getParcelableExtra<Community>("community")!!

        community?.image?.toIntOrNull()?.let { binding.logo.setImageResource(it) }
        binding.namaKomunitas.setText(community?.name)
        binding.totalMember.setText("${community?.members.toString()} Anggota")


        binding.arrowBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}
package com.waterseven.macro.lestari.presentation.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.ActivityCommunityDetailBinding
import com.waterseven.macro.lestari.model.community.Community

class CommunityDetail : AppCompatActivity() {
    private lateinit var logo : ImageView
    private lateinit var namaKomunitas : TextView
    private lateinit var total_member : TextView
    private lateinit var tabs : TabLayout
    private lateinit var binding: ActivityCommunityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val community = intent.getParcelableExtra<Community>("community")
        community?.image?.toIntOrNull()?.let { binding.logo.setImageResource(it) }
        binding.namaKomunitas.setText(community?.name)
        binding.totalMember.setText("${community?.members.toString()} Anggota")
        tabs = binding.tabs


        tabs.getTabAt(0)?.select()

        if(tabs.getTabAt(0)?.isSelected!!){
            replaceFragment(CommunityInfo.newInstance("",""))
        }else{
        }


        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> replaceFragment(CommunityInfo.newInstance("",""))
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.detailCommunityFragmentContainer, fragment)
        fragmentTransaction.commit()
    }

}
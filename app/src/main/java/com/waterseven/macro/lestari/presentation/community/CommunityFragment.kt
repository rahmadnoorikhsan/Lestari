package com.waterseven.macro.lestari.presentation.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.FragmentCommunityBinding

class CommunityFragment : Fragment() {

    private var _binding: FragmentCommunityBinding? = null
    private  val binding get() = _binding

    private lateinit var myCommunity: TabLayout.Tab
    private lateinit var communitySharing: TabLayout.Tab

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommunityBinding.inflate(layoutInflater, container, false)
        val tabs = binding?.tabs
        myCommunity = tabs?.getTabAt(0)!!
        communitySharing = tabs.getTabAt(1)!!
        myCommunity.select()

        if(myCommunity.isSelected){
            komunitasSaya()
        }else{
//            cariKomunitas()
        }

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> {
                        komunitasSaya()
                    }
//                    1 -> cariKomunitas()
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
            }
        })

        return binding?.root
    }

    private fun komunitasSaya( ) {
        val hasilFragment = MyCommunity() // Ganti dengan fragment yang sesuai
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.communityFragmentContainer, hasilFragment)
        transaction.commit()
    }

//    private fun cariKomunitas( ) {
//        val hasilFragment = CommunitySharing() // Ganti dengan fragment yang sesuai
//        val transaction = parentFragmentManager.beginTransaction()
//        transaction.replace(R.id.communityFragmentContainer, hasilFragment)
//        transaction.commit()
//    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
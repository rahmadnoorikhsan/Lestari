package com.waterseven.macro.lestari.presentation.home.information.event.competition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.FragmentDetailCompetitionBinding
import com.waterseven.macro.lestari.utils.Extensions.showImageInto

class DetailCompetitionFragment: Fragment() {

    private var _binding: FragmentDetailCompetitionBinding? = null
    private val binding get()= _binding
    private val navArgs: DetailCompetitionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDetailCompetitionBinding.inflate(layoutInflater, container, false)
        return  binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpToolbar()
        setUpView()
    }

    private fun setUpToolbar() {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowTitleEnabled(false)
            }
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {}

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                findNavController().navigateUp()
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.CREATED)
    }



    private fun setUpView() {
        val competition = navArgs.competition
        binding?.apply {
            image.showImageInto(requireActivity(),competition.image)
            tvTitle.text = competition.title
            tvDate.text = getString(R.string.date, competition.date)
            tvTime.text = getString(R.string.time, competition.time)
            tvLocation.text = getString(R.string.locations, competition.location)
            tvActor.text = "CEO " + competition.actor
            tvDescription.text = competition.description
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
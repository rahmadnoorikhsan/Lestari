package com.waterseven.macro.lestari.presentation.home.information.event.show

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
import com.waterseven.macro.lestari.databinding.FragmentDetailShowBinding
import com.waterseven.macro.lestari.utils.Extensions.showImageInto

class DetailShowFragment : Fragment() {

    private var _binding:FragmentDetailShowBinding? = null
    private val binding get()= _binding
    private val navArgs: DetailShowFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDetailShowBinding.inflate(layoutInflater, container, false)
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
        val show = navArgs.show
        binding?.apply {
            image.showImageInto(requireActivity(),show.image)
            tvTitle.text = show.title
            tvDate.text = getString(R.string.date, show.date)
            tvTime.text = getString(R.string.time, show.time)
            tvLocation.text = getString(R.string.locations, show.location)
            tvActor.text = getString(R.string.actor, show.actor)
            tvDescription.text = show.description
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}
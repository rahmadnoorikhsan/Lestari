package com.waterseven.macro.lestari.presentation.home.museum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.data.museum.MuseumsData
import com.waterseven.macro.lestari.databinding.FragmentMuseumBinding
import com.waterseven.macro.lestari.model.museum.Museum
import com.waterseven.macro.lestari.presentation.home.adapter.MuseumAdapter

class MuseumFragment : Fragment() {

    private var _binding: FragmentMuseumBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMuseumBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpToolbar()
        showListMuseum()
    }


    private fun setUpToolbar() {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayShowTitleEnabled(false)
                setHomeAsUpIndicator(ContextCompat.getDrawable(requireActivity(), R.drawable.ic_close_24))
                setDisplayHomeAsUpEnabled(true)
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

    private fun showListMuseum() {
        val museumsData = MuseumsData.museumDummy

        val adapters = MuseumAdapter { museum ->
            navigateToDetail(museum)
        }

        binding?.rvMuseum?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = adapters
        }
        adapters.submitList(museumsData)
    }

    private fun navigateToDetail(museum: Museum) {
        val data = MuseumFragmentDirections.actionMuseumFragmentToDialogMuseumFragment(museum)
        findNavController().navigate(data)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
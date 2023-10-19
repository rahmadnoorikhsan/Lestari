package com.waterseven.macro.lestari.presentation.home.culture

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.data.culture.CulturesData
import com.waterseven.macro.lestari.databinding.FragmentCultureBinding
import com.waterseven.macro.lestari.presentation.home.adapter.CultureAdapter

class CultureFragment : Fragment() {

    private var _binding: FragmentCultureBinding? = null
    private val binding get() = _binding
    private lateinit var cultureAdapter: CultureAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCultureBinding.inflate(layoutInflater, container, false)
        return binding?.root
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
                title = getString(R.string.culture)
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
        val cultureData = CulturesData.dummyCultures

        cultureAdapter = CultureAdapter { culture ->
            val data = CultureFragmentDirections.actionCultureFragmentToCultureDetailActivity(culture)
            findNavController().navigate(data)
        }

        binding?.rvCulture?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = cultureAdapter
        }
        cultureAdapter.submitList(cultureData)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
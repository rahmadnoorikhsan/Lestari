package com.waterseven.macro.lestari.presentation.home.information.article

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
import com.waterseven.macro.lestari.data.article.ArticlesData
import com.waterseven.macro.lestari.databinding.FragmentArticleBinding
import com.waterseven.macro.lestari.presentation.home.information.article.adapter.ArticleAdapter

class ArticleFragment : Fragment() {

    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding
    private lateinit var articleAdapter: ArticleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpToolBar()
        setUpRecyclerView()
    }

    private fun setUpToolBar() {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                title = getString(R.string.article)
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

    private fun setUpRecyclerView() {
        val article = ArticlesData.dummyArticles

        articleAdapter = ArticleAdapter { articles ->
            val action = ArticleFragmentDirections.actionArticleFragmentToDetailArticleFragment(articles)
            findNavController().navigate(action)
        }

        binding?.rvArticle?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = articleAdapter
        }

        articleAdapter.submitList(article)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
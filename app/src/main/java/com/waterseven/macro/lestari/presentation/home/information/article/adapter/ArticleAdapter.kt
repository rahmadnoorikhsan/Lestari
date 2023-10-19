package com.waterseven.macro.lestari.presentation.home.information.article.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.databinding.ItemCultureBinding
import com.waterseven.macro.lestari.model.article.Article
import com.waterseven.macro.lestari.utils.Extensions.showImageInto

class ArticleAdapter(val data: (Article) -> Unit) : ListAdapter<Article, ArticleAdapter.ArticleView>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleView {
        val binding = ItemCultureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleView(binding)
    }

    override fun onBindViewHolder(holder: ArticleView, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ArticleView(private val binding: ItemCultureBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.apply {
                ivCover.showImageInto(itemView.context, article.imageUrl)
                tvTitle.text = article.title
                tvPlace.text = article.publisher
                itemView.setOnClickListener { data.invoke(article) }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem.id == newItem.id
        }
    }
}
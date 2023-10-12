package com.waterseven.macro.lestari.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.model.culture.Culture
import com.waterseven.macro.lestari.databinding.ItemCultureBinding
import com.waterseven.macro.lestari.utils.Extensions.showImageInto

class CultureAdapter(val data: (Culture) -> Unit) : ListAdapter<Culture, CultureAdapter.CultureViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CultureViewHolder {
        val binding = ItemCultureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CultureViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CultureViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CultureViewHolder(private val binding: ItemCultureBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(culture: Culture) {
            binding.apply {
                tvTitle.text = culture.title
                tvPlace.text = culture.place
                ivCover.showImageInto(itemView.context, culture.imageCover)
                itemView.setOnClickListener { data.invoke(culture) }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Culture>() {
            override fun areItemsTheSame(oldItem: Culture, newItem: Culture) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Culture, newItem: Culture): Boolean =
                oldItem.id == newItem.id
        }
    }
}
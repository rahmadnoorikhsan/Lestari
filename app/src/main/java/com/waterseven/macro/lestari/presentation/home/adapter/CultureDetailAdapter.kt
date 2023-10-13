package com.waterseven.macro.lestari.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.databinding.ItemImageCultureBinding
import com.waterseven.macro.lestari.model.culture.ImageCulture
import com.waterseven.macro.lestari.utils.Extensions.showImageInto

class CultureDetailAdapter : ListAdapter<ImageCulture, CultureDetailAdapter.DetailCultureViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailCultureViewHolder {
        val binding = ItemImageCultureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailCultureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailCultureViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class DetailCultureViewHolder(private val binding: ItemImageCultureBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(imageCulture: ImageCulture) {
            binding.apply {
                ivImageAsset.showImageInto(itemView.context, imageCulture.url)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ImageCulture>() {
            override fun areItemsTheSame(oldItem: ImageCulture, newItem: ImageCulture) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: ImageCulture, newItem: ImageCulture): Boolean =
                oldItem.id == newItem.id
        }
    }
}
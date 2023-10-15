package com.waterseven.macro.lestari.presentation.home.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.databinding.ItemMuseumBinding
import com.waterseven.macro.lestari.model.museum.Museum
import com.waterseven.macro.lestari.utils.Extensions.showImageInto

class MuseumAdapter(val data: (Museum) -> Unit) : ListAdapter<Museum, MuseumAdapter.MuseumViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumViewHolder {
        val binding = ItemMuseumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MuseumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MuseumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MuseumViewHolder(private val binding: ItemMuseumBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(museum: Museum) {
            binding.apply {
                ivMuseum.showImageInto(itemView.context, museum.imageUrl)
                ivMuseum.setOnClickListener { data.invoke(museum) }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Museum>() {
            override fun areItemsTheSame(oldItem: Museum, newItem: Museum) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Museum, newItem: Museum): Boolean =
                oldItem.id == newItem.id
        }
    }
}
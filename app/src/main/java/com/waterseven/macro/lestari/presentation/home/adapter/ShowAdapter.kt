package com.waterseven.macro.lestari.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.databinding.ItemShowBinding
import com.waterseven.macro.lestari.model.show.Show
import com.waterseven.macro.lestari.utils.Extensions.showImageInto

class ShowAdapter(val data: (Show) -> Unit) : ListAdapter<Show,ShowAdapter.ShowViewHolder>(DIFF_CALLBACK) {
    inner class ShowViewHolder(private val binding: ItemShowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(show: Show){
            binding.apply {
                image.showImageInto(itemView.context,show.image)
                tvTitle.text = show.title
                tvDate.text = show.date
                tvLocation.text = show.location
                itemView.setOnClickListener{
                    data.invoke(show)
                }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Show>() {
            override fun areItemsTheSame(oldItem: Show, newItem: Show) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Show, newItem: Show): Boolean =
                oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val binding = ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
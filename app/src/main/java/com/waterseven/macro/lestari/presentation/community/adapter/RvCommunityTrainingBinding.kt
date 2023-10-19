package com.waterseven.macro.lestari.presentation.community.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.databinding.JadwalTrainingBinding
import com.waterseven.macro.lestari.model.community.ForumCommunity

class RvCommunityTrainingBinding : ListAdapter<ForumCommunity, RvCommunityTrainingBinding.CommunityTrainingViewHolder>(
    RvCommunityForumAdapter.DIFF_CALLBACK
)   {
    inner class CommunityTrainingViewHolder(private val binding: JadwalTrainingBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(community: ForumCommunity) {
            binding.apply {
                namaForum.text = community.name
                itemView.setOnClickListener {
                    Toast.makeText(itemView.context, "Fitur ini sedang dalam tahap pengembangan", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvCommunityTrainingBinding.CommunityTrainingViewHolder {
        val binding = JadwalTrainingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommunityTrainingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommunityTrainingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ForumCommunity>() {
            override fun areItemsTheSame(oldItem: ForumCommunity, newItem: ForumCommunity) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: ForumCommunity, newItem: ForumCommunity): Boolean =
                oldItem == newItem
        }
    }
}
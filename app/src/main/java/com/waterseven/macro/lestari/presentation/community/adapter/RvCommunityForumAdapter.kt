package com.waterseven.macro.lestari.presentation.community.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.databinding.ListForumBinding
import com.waterseven.macro.lestari.model.community.ForumCommunity

class RvCommunityForumAdapter() :
    ListAdapter<ForumCommunity, RvCommunityForumAdapter.CommunityForumViewHolder>(
        DIFF_CALLBACK
    ) {

    inner class CommunityForumViewHolder(private val binding: ListForumBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(community: ForumCommunity) {
            binding.apply {
                namaForum.text = community.name
                community.chats.forEach {
                    user.text = it.name
                    pesanForum.text = "${it.message.substring(0, 15)}..."
                }
                itemView.setOnClickListener {
                    Toast.makeText(itemView.context, "Fitur ini sedang dalam tahap pengembangan", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RvCommunityForumAdapter.CommunityForumViewHolder {
        val binding = ListForumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommunityForumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommunityForumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ForumCommunity>() {
            override fun areItemsTheSame(oldItem: ForumCommunity, newItem: ForumCommunity) =
                oldItem == newItem

            override fun areContentsTheSame(
                oldItem: ForumCommunity,
                newItem: ForumCommunity
            ): Boolean =
                oldItem == newItem
        }
    }


}
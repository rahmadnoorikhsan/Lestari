package com.waterseven.macro.lestari.presentation.community.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.databinding.FragmentCommunityForumBinding
import com.waterseven.macro.lestari.databinding.ListForumBinding
import com.waterseven.macro.lestari.model.community.Community

class RvCommunityForumAdapter(val data: (Community) -> Unit) : ListAdapter<Community, RvCommunityForumAdapter.CommunityForumViewHolder>(
    RvCommunitySharingAdapter.DIFF_CALLBACK
)  {

    inner class CommunityForumViewHolder(private val binding: ListForumBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(community: Community) {

                val chatMessages = community.forum.map { it.chats }.flatMap { it.map { it.message } }
                binding.apply {
                namaForum.text = community.name
                pesanForum.text = chatMessages.toString()
                itemView.setOnClickListener {
                        data(community)
                    }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): RvCommunityForumAdapter.CommunityForumViewHolder {
        val binding = ListForumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommunityForumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommunityForumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}
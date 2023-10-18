package com.waterseven.macro.lestari.presentation.community.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.databinding.FragmentCommunityForumBinding
import com.waterseven.macro.lestari.databinding.ListForumBinding
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.model.community.ForumCommunity
import com.waterseven.macro.lestari.model.culture.Culture

class RvCommunityForumAdapter(val data: (Community) -> Unit) : ListAdapter<Community, RvCommunityForumAdapter.CommunityForumViewHolder>(
    DIFF_CALLBACK
)  {

    inner class CommunityForumViewHolder(private val binding: ListForumBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(community: Community) {

                val chatMessages = community.forum.map{it.chats}
                val person = chatMessages.forEach { it.forEach{it.name} }
                val chat = chatMessages.forEach { it.forEach{it.message} }
                binding.apply {
                namaForum.text = community.name
                user.text = person.toString()
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

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Community>() {
            override fun areItemsTheSame(oldItem: Community, newItem: Community) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Community, newItem: Community): Boolean =
                oldItem == newItem
        }
    }


}
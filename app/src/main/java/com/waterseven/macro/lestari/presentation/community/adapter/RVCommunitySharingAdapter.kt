package com.waterseven.macro.lestari.presentation.community.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.databinding.CardCariKomunitasBinding
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.utils.Extensions.showImageInto

class RvCommunitySharingAdapter(val data: (Community) -> Unit) : ListAdapter<Community, RvCommunitySharingAdapter.CommunitySharingViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): RvCommunitySharingAdapter.CommunitySharingViewHolder {
        val binding = CardCariKomunitasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommunitySharingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommunitySharingViewHolder,position: Int) {
        holder.bind(getItem(position))
    }

    inner class CommunitySharingViewHolder(private val binding: CardCariKomunitasBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(community: Community) {
            binding.apply {
                logoKomunitas.showImageInto(itemView.context, community.image)
                namaKomunitas.text = community.name
                deskripsiKomunitas.text = community.desc
                alamatKomunitas.text = community.location
                info.text = "${community.members} Member • ${community.trainings.size} Pelatihan"
                itemView.setOnClickListener {data.invoke(community)}
                btnJoin.setOnClickListener {
                    Toast.makeText(itemView.context, "Fitur ini sedang dalam tahap pengembangan", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Community>() {
            override fun areItemsTheSame(oldItem: Community, newItem: Community): Boolean {
                TODO("Not yet implemented")
            }

            override fun areContentsTheSame(oldItem: Community, newItem: Community): Boolean {
                TODO("Not yet implemented")
            }

        }
    }

}
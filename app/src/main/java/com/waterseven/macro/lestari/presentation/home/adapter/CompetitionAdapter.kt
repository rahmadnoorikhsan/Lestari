package com.waterseven.macro.lestari.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.databinding.ItemCompetitionBinding
import com.waterseven.macro.lestari.model.competition.Competition
import com.waterseven.macro.lestari.utils.Extensions.showImageInto


class CompetitionAdapter(val data: (Competition) -> Unit) : ListAdapter<Competition, CompetitionAdapter.CompetitionViewHolder>(DIFF_CALLBACK) {
    inner class CompetitionViewHolder(private val binding: ItemCompetitionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(competition: Competition) {
            binding.apply {
                image.showImageInto(itemView.context, competition.image)
                tvTitle.text = competition.title
                tvDate.text = competition.date
                tvLocation.text = competition.location
                itemView.setOnClickListener {
                    data.invoke(competition)
                }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Competition>() {
            override fun areItemsTheSame(oldItem: Competition, newItem: Competition) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Competition, newItem: Competition): Boolean =
                oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionViewHolder {
        val binding = ItemCompetitionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompetitionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
package com.waterseven.macro.lestari.presentation.community.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.databinding.KomunitasKuBinding
import com.waterseven.macro.lestari.model.community.Community
import com.waterseven.macro.lestari.presentation.community.fragment.detail.CommunityDetail
import com.waterseven.macro.lestari.utils.Extensions.showImageInto

class RvCommunityAdapter(val data: (Community) -> Unit) : ListAdapter<Community, RvCommunityAdapter.CommunityViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityViewHolder {
        val binding = KomunitasKuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommunityViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CommunityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CommunityViewHolder(private val binding: KomunitasKuBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(community: Community) {
            binding.apply {
                logo.showImageInto(itemView.context, community.image)
                tvNamaKomunitas.text = community.name
                tvDeskripsi.text = community.desc
                titleForum.text= community.forum.size.toString() + " Forum"
                titlePelatihan.text = community.trainings.size.toString() + " Pelatihan"
                itemView.setOnClickListener {
                    data.invoke(community)
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
//    RecyclerView.Adapter<RvCommunityAdapter.ViewHolder>(){
//    class ViewHolder(val binding: KomunitasKuBinding): RecyclerView.ViewHolder(binding.root)
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding = KomunitasKuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int = list.size
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        with(holder){
//            with(list[position]){
//                binding.logo.setImageResource(this.image)
//                binding.tvNamaKomunitas.text= this.name
//                binding.tvDeskripsi.text= this.desc
//            }
//        }
//    }
//}
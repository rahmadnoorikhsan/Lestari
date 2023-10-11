package com.waterseven.macro.lestari.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.databinding.KomunitasKuBinding
import com.waterseven.macro.lestari.model.community.komunitas

class RvCommunityAdapter(private val list:List<komunitas>) :
    RecyclerView.Adapter<RvCommunityAdapter.ViewHolder>(){
    class ViewHolder(val binding: KomunitasKuBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = KomunitasKuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.imageView2.setImageResource(this.image)
                binding.tvNamaKomunitas.text= this.name
                binding.tvDeskripsi.text= this.desc
            }
        }
    }
}
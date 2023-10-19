package com.waterseven.macro.lestari.presentation.watch.adapter

import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.ItemWatchBinding
import com.waterseven.macro.lestari.model.watch.Watch

class WatchAdapter : ListAdapter<Watch, WatchAdapter.WatchHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchHolder {
        val binding = ItemWatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  WatchHolder(binding)
    }

    override fun onBindViewHolder(holder: WatchHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class WatchHolder(private val binding: ItemWatchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(watch: Watch) {
            binding.apply {
                video.apply {
                    setVideoURI(Uri.parse(watch.videoUrl))

                    setOnPreparedListener { mp ->
                        progressBar.visibility = View.GONE
                        mp.start()

                        val videoRatio = mp.videoWidth.toFloat() / mp.videoHeight.toFloat()
                        val screenRatio = video.width.toFloat() / video.height.toFloat()

                        val scale = videoRatio / screenRatio
                        if (scale > 1f) {
                            video.scaleX = scale
                        } else {
                            video.scaleY = (1f / scale)
                        }
                    }

                    setOnCompletionListener {
                        MediaPlayer.OnCompletionListener { mp ->
                            mp.start()
                        }
                    }
                }

                tvInitial.text = watch.account[0].toString().uppercase()
                tvName.text = watch.account
                tvDescription.text = watch.description
                icMore.setOnClickListener {
                    Toast.makeText(itemView.context, "Fitur ini sedang dikembangkan", Toast.LENGTH_SHORT).show()
                }
                icShare.setOnClickListener {
                    Toast.makeText(itemView.context, "Fitur ini sedang dikembangkan", Toast.LENGTH_SHORT).show()
                }
                icFavorite.setOnClickListener {
                    val isFav = false

                    if (isFav) {
                        icFavorite.setImageResource(R.drawable.baseline_favorite_border_24)
                    } else {
                        icFavorite.setImageResource(R.drawable.baseline_favorite_24)
                    }
                }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Watch>() {
            override fun areItemsTheSame(oldItem: Watch, newItem: Watch) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Watch, newItem: Watch): Boolean =
                oldItem.id == newItem.id
        }
    }
}
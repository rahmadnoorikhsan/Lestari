package com.waterseven.macro.lestari.presentation.home.culture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.waterseven.macro.lestari.databinding.ActivityCultureDetailBinding
import com.waterseven.macro.lestari.presentation.home.adapter.CultureDetailAdapter
import com.waterseven.macro.lestari.utils.Extensions.showImageInto


class CultureDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCultureDetailBinding
    private val navArgs: CultureDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCultureDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()
    }

    private fun setUpView() {
        val culture = navArgs.culture
        val imageAdapter = CultureDetailAdapter()

        binding.contentDetail.apply {
            ivCover.showImageInto(this@CultureDetailActivity, culture.imageCover)
            tvTitle.text = culture.title
            tvPlace.text = culture.place
            tvDescription.text = culture.description
            lifecycle.addObserver(ytPlayer)
            ytPlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = culture.video
                    youTubePlayer.loadVideo(videoId, 0f)
                }
            })
            rvImage.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = imageAdapter
                imageAdapter.submitList(culture.imageAsset)
            }
        }
    }
}
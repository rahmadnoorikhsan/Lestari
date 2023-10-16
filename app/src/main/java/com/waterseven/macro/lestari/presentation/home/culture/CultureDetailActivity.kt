package com.waterseven.macro.lestari.presentation.home.culture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.waterseven.macro.lestari.databinding.ActivityCultureDetailBinding
import com.waterseven.macro.lestari.model.culture.Culture
import com.waterseven.macro.lestari.presentation.home.adapter.CultureDetailAdapter
import com.waterseven.macro.lestari.utils.Extensions.showImageInto


class CultureDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCultureDetailBinding
    private val navArgs: CultureDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCultureDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setNavigateBack()
        setUpView()
    }

    private fun setNavigateBack() {
        binding.contentDetail.btnBack.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setUpView() {
        val culture = navArgs.culture

        binding.contentDetail.apply {
            ivCover.showImageInto(this@CultureDetailActivity, culture.imageCover)
            tvTitle.text = culture.title
            tvPlace.text = culture.place
            tvDescription.text = culture.description
        }

        setUpYoutubeApi(culture)
        setRecycleView(culture)
    }

    private fun setUpYoutubeApi(culture: Culture) {
        binding.contentDetail.apply {
            lifecycle.addObserver(ytPlayer)
            ytPlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = culture.video
                    youTubePlayer.loadVideo(videoId, 0f)
                }
            })
        }
    }

    private fun setRecycleView(culture: Culture) {
        val imageAdapter = CultureDetailAdapter()

        binding.contentDetail.rvImage.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = imageAdapter
            imageAdapter.submitList(culture.imageAsset)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.contentDetail.ytPlayer.release()
    }
}
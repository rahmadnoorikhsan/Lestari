package com.waterseven.macro.lestari.presentation.home.culture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ActivityNavigator
import androidx.navigation.navArgs
import com.waterseven.macro.lestari.databinding.ActivityCultureDetailBinding
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

        binding.contentDetail.apply {
            ivCover.showImageInto(this@CultureDetailActivity, culture.imageCover)
            tvTitle.text = culture.title
            tvPlace.text = culture.place
            tvDescription.text = culture.description
        }
    }

    override fun finish() {
        super.finish()
        ActivityNavigator.applyPopAnimationsToPendingTransition(this)
    }
}
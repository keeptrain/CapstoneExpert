package com.submission.expert1.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.submission.expert1.R
import com.submission.expert1.databinding.ActivityDetailGamesBinding
import com.submission.expert1.domain.model.Games
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class DetailGamesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailGamesBinding

    private val detailGamesViewModel: DetailGamesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailGames = intent.getParcelableExtra<Games>(EXTRA_DATA)
        detailGames(detailGames)
    }

    private fun detailGames(detailGames: Games?) {

        detailGames?.let {
            Glide.with(this@DetailGamesActivity)
                .load(detailGames.image)
                .into(binding.ivDetailImage)
            binding.tvGames.text = detailGames.name
            binding.tvRating.text = getString(R.string.text_rating, detailGames.rating.toString())
            binding.tvRelease.text = getString(R.string.text_released, detailGames.released)
            binding.tvPlaytime.text = getString(R.string.text_playtime, detailGames.playtime.toString())

            var statusFavorite = detailGames.isFavorite
            setStatusFavorite(statusFavorite)

            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailGamesViewModel.setFavoriteGames(detailGames, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }

    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
           binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_nofavorite_white))
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}
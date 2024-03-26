package com.submission.expert1.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.submission.expert1.detail.DetailGamesActivity
import com.submission.expert1.di.FavoriteModuleDependencies
import com.submission.expert1.domain.model.Games
import com.submission.expert1.favorite.databinding.FragmentFavoriteBinding
import com.submission.expert1.favorite.di.DaggerFavoriteComponent
import com.submission.expert1.ui.GamesAdapter
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject


class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFavoriteComponent.builder()
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireContext(),
                    FavoriteModuleDependencies::class.java
                )
            )
            .context(requireContext())
            .build()
            .inject(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val gamesAdapter = GamesAdapter()
            gamesAdapter.setOnClickCallback(object : GamesAdapter.OnClickCallback {
                override fun onItemClick(item: Games) {
                    val intent = Intent(activity, DetailGamesActivity::class.java)
                    intent.putExtra(DetailGamesActivity.EXTRA_DATA, item)
                    startActivity(intent)
                }
            })

            favoriteViewModel.favoriteGames.observe(viewLifecycleOwner) { dataGames ->
                gamesAdapter.submitList(dataGames)
                binding.tvEmpty.visibility = if (dataGames.isNotEmpty()) View.GONE else View.VISIBLE
            }

            with(binding.rvGames) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = gamesAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
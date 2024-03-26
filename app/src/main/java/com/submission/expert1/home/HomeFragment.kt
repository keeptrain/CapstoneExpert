package com.submission.expert1.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.submission.expert1.R
import com.submission.expert1.data.Resource
import com.submission.expert1.databinding.FragmentHomeBinding
import com.submission.expert1.detail.DetailGamesActivity
import com.submission.expert1.domain.model.Games
import com.submission.expert1.ui.GamesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
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

            homeViewModel.games.observe(viewLifecycleOwner) { games->
                if (games != null) {
                    when (games) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            gamesAdapter.submitList(games.data)
                        }

                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text =
                                games.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
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
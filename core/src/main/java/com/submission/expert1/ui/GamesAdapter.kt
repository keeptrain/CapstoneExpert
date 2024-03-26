package com.submission.expert1.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.submission.expert1.core.R
import com.submission.expert1.core.databinding.ItemListGamesBinding
import com.submission.expert1.domain.model.Games

class GamesAdapter : ListAdapter <Games, GamesAdapter.ListViewHolder>(DIFF_CALLBACK) {

    interface OnClickCallback {
        fun onItemClick(item: Games)
    }

    private lateinit var onItemClickCallback: OnClickCallback

    fun setOnClickCallback(onItemClickCallback: OnClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_games, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClick(getItem(holder.adapterPosition)) }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListGamesBinding.bind(itemView)
        fun bind(data: Games) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(ivItemImage)
                tvItemTitle.text = data.name
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Games>() {
            override fun areItemsTheSame(oldItem: Games, newItem: Games): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Games, newItem: Games): Boolean {
                return oldItem == newItem
            }
        }
    }
}
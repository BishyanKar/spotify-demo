package com.example.spotifyassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.spotifyassignment.databinding.LayoutItemSearchBinding
import com.example.spotifyassignment.model.local.SearchItem
import com.example.spotifyassignment.ui.adapter.listener.SearchItemAdapterListener

class SearchItemAdapter(
    private val searchItemAdapterListener: SearchItemAdapterListener
): ListAdapter<SearchItem, SearchItemAdapter.SearchItemViewHolder>(DiffUtilItemCallback) {

    object DiffUtilItemCallback : DiffUtil.ItemCallback<SearchItem>() {
        override fun areItemsTheSame(
            oldItem: SearchItem,
            newItem: SearchItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: SearchItem,
            newItem: SearchItem
        ): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder {
        val binding = LayoutItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchItemViewHolder(binding, searchItemAdapterListener)
    }

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SearchItemViewHolder(
        private val binding: LayoutItemSearchBinding,
        private val searchItemAdapterListener: SearchItemAdapterListener
    ): ViewHolder(binding.root) {
        fun bind(searchItem: SearchItem) {
            binding.tvItemSearchName.text = searchItem.name
            binding.tvItemSearchCreator.text = searchItem.creator
            binding.tvItemSearchDate.text = searchItem.date

            searchItemAdapterListener.onLoadImage(searchItem.img, binding.ivItemSearch)

            binding.cvItemImage.setOnClickListener {
                searchItemAdapterListener.onItemClick(searchItem.id)
            }
        }
    }
}
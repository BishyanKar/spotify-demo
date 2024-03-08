package com.example.spotifyassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyassignment.databinding.LayoutItemDetailBinding

class ItemDetailAdapter(private val detailsSet: List<String>) :
    RecyclerView.Adapter<ItemDetailAdapter.ItemDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDetailViewHolder {
        val binding = LayoutItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemDetailViewHolder, position: Int) {
        holder.bind(detailsSet[position])
    }

    override fun getItemCount(): Int {
        return detailsSet.size
    }

    class ItemDetailViewHolder(
        private val binding: LayoutItemDetailBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(detail: String) {
            binding.tvItemDetailTitle.text = detail.split(":")[0]
            binding.tvItemDetailValue.text = detail.split(":")[1]
        }
    }
}
package com.example.spotifyassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyassignment.databinding.LayoutItemSearchTypeBinding
import com.example.spotifyassignment.ui.adapter.listener.SearchTypeAdapterListener

class SearchTypeAdapter(
    private val types: List<String>,
    private val searchTypeAdapterListener: SearchTypeAdapterListener
):
    RecyclerView.Adapter<SearchTypeAdapter.TypeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        val binding = LayoutItemSearchTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TypeViewHolder(binding, searchTypeAdapterListener)
    }

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        holder.bind(types[position])
    }

    override fun getItemCount(): Int {
        return types.size
    }

    class TypeViewHolder(
        private val binding: LayoutItemSearchTypeBinding,
        private val searchTypeAdapterListener: SearchTypeAdapterListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(type: String) {
            binding.tvSearchType.text = type
            binding.clItemSearchType.setOnClickListener {
                searchTypeAdapterListener.onClick(type)
            }
        }
    }
}
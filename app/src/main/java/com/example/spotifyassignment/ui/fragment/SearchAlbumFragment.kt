package com.example.spotifyassignment.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.spotifyassignment.databinding.FragmentSearchAlbumBinding
import com.example.spotifyassignment.model.local.SearchItem
import com.example.spotifyassignment.ui.adapter.SearchItemAdapter
import com.example.spotifyassignment.ui.adapter.listener.SearchItemAdapterListener
import com.example.spotifyassignment.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.stream.Collectors

@AndroidEntryPoint
class SearchAlbumFragment : Fragment(), SearchItemAdapterListener {

    private var _binding: FragmentSearchAlbumBinding? = null
    private val binding get() = _binding!!

    private lateinit var searchViewModel: SearchViewModel

    private lateinit var rvAlbum: RecyclerView
    private lateinit var searchItemAdapter: SearchItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchAlbumBinding.inflate(inflater, container, false)

        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvAlbum = binding.rvAlbum
        searchItemAdapter = SearchItemAdapter(this)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvAlbum.adapter = searchItemAdapter
        rvAlbum.layoutManager = GridLayoutManager(requireContext(), 2)
        searchViewModel.albums.observe(viewLifecycleOwner, Observer {entities ->
            val searchItems = entities.stream().map {entity ->
                SearchItem(
                    entity.id,
                    entity.name ?: "",
                    entity.imgUrls?.get(0) ?: "",
                    entity.artistNames?.joinToString(separator = ",") ?: "No Name",
                    entity.releaseDate
                )
            }.collect(Collectors.toList())

            searchItemAdapter.submitList(searchItems)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLoadImage(url: String, imageView: ImageView) {
        val circularProgressDrawable = CircularProgressDrawable(requireContext())
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        Glide.with(this)
            .load(url)
            .placeholder(circularProgressDrawable)
            .into(imageView)
    }

    override fun onItemClick(id: String) {
        TODO("Not yet implemented")
    }
}
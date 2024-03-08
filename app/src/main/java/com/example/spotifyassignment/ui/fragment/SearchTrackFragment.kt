package com.example.spotifyassignment.ui.fragment

import android.content.Intent
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
import com.example.spotifyassignment.Constants
import com.example.spotifyassignment.R
import com.example.spotifyassignment.databinding.FragmentSearchTrackBinding
import com.example.spotifyassignment.model.local.SearchItem
import com.example.spotifyassignment.ui.activity.SearchItemDetailActivity
import com.example.spotifyassignment.ui.adapter.TrackAdapter
import com.example.spotifyassignment.ui.adapter.listener.SearchItemAdapterListener
import com.example.spotifyassignment.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.stream.Collectors

@AndroidEntryPoint
class SearchTrackFragment : Fragment(), SearchItemAdapterListener {

    private var _binding: FragmentSearchTrackBinding? = null
    private val binding get() = _binding!!
    private lateinit var searchViewModel: SearchViewModel

    private lateinit var rvTrack: RecyclerView
    private lateinit var searchItemAdapter: TrackAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchTrackBinding.inflate(inflater, container, false)
        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvTrack = binding.rvTrack
        searchItemAdapter = TrackAdapter(this)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvTrack.adapter = searchItemAdapter
        rvTrack.layoutManager = GridLayoutManager(requireContext(), 2)
        searchViewModel.tracks.observe(viewLifecycleOwner, Observer {entities ->
            var searchItems = listOf<SearchItem>()
            if (entities.isNotEmpty()) {
                rvTrack.visibility = View.VISIBLE
                binding.tvNoItems.visibility = View.GONE
                searchItems = entities.stream().map { entity ->
                    SearchItem(
                        entity.id,
                        entity.name ?: "",
                        entity.uri ?: "",
                        entity.artistNames?.joinToString(", ") ?: "",
                        albumName = entity.albumName,
                        duration = ((entity.durationMs?.div(60*1000) ?: 0)).toString()+" min",
                        type = "track"
                    )
                }.collect(Collectors.toList())
            } else {
                rvTrack.visibility = View.GONE
                binding.tvNoItems.visibility = View.VISIBLE
            }
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
            .load(R.drawable.ic_track_img)
            .placeholder(circularProgressDrawable)
            .into(imageView)
    }

    override fun onItemClick(searchItem: SearchItem) {
        val intent = Intent(requireActivity(), SearchItemDetailActivity::class.java)
        intent.putExtra(Constants.KEY_ITEM_EXTRA, searchItem)
        startActivity(intent)
    }
}
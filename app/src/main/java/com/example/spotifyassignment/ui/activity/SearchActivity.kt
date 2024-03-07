package com.example.spotifyassignment.ui.activity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyassignment.R
import com.example.spotifyassignment.databinding.ActivitySearchBinding
import com.example.spotifyassignment.ui.adapter.SearchTypeAdapter
import com.example.spotifyassignment.ui.adapter.listener.SearchTypeAdapterListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity(), SearchTypeAdapterListener {

    private lateinit var binding: ActivitySearchBinding

    private lateinit var rvSearchTypes: RecyclerView

    private lateinit var searchTypeAdapter: SearchTypeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_search)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvSearchTypes = binding.rvSearchType

        val types = arrayListOf("Tracks", "Artists", "Albums")
        searchTypeAdapter = SearchTypeAdapter(types, this)

        rvSearchTypes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvSearchTypes.adapter = searchTypeAdapter
    }

    override fun onClick(type: String) {
        //todo render different fragments
    }
}
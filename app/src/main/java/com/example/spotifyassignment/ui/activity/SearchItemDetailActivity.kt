package com.example.spotifyassignment.ui.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyassignment.Constants
import com.example.spotifyassignment.R
import com.example.spotifyassignment.databinding.ActivitySearchItemDetailBinding
import com.example.spotifyassignment.model.local.SearchItem
import com.example.spotifyassignment.ui.adapter.ItemDetailAdapter
import java.util.Objects

class SearchItemDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchItemDetailBinding

    private lateinit var rvDetails: RecyclerView
    private lateinit var itemDetailAdapter: ItemDetailAdapter

    private var searchItem: SearchItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvDetails = binding.rvItemDetail

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            searchItem = intent.getParcelableExtra(Constants.KEY_ITEM_EXTRA, SearchItem::class.java)
        } else {
            searchItem = intent.getParcelableExtra<SearchItem>(Constants.KEY_ITEM_EXTRA)
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val itemList = arrayListOf<String>()
        if (Objects.nonNull(searchItem)) {
            itemList.add("Name: ${searchItem?.name}")
        }

        itemDetailAdapter = ItemDetailAdapter(itemList)

        rvDetails.adapter = itemDetailAdapter
        rvDetails.layoutManager = LinearLayoutManager(this)
    }
}
package com.example.spotifyassignment.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.spotifyassignment.R
import com.example.spotifyassignment.databinding.ActivitySearchBinding
import com.example.spotifyassignment.databinding.LayoutItemSearchTypeBinding
import com.example.spotifyassignment.ui.adapter.ViewPagerAdapter
import com.example.spotifyassignment.ui.fragment.SearchAlbumFragment
import com.example.spotifyassignment.ui.fragment.SearchArtistFragment
import com.example.spotifyassignment.ui.fragment.SearchAudioBookFragment
import com.example.spotifyassignment.ui.fragment.SearchEpisodeFragment
import com.example.spotifyassignment.ui.fragment.SearchPlayListFragment
import com.example.spotifyassignment.ui.fragment.SearchShowFragment
import com.example.spotifyassignment.ui.fragment.SearchTrackFragment
import com.example.spotifyassignment.viewmodel.SearchViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding

    private lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        initViewPager()

        binding.etSearch.setOnEditorActionListener(OnEditorActionListener { view, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboard()
                toggleProgressBar(true)
                searchMusic(view.text.toString())
                return@OnEditorActionListener true
            }
            false
        })
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.etSearch.windowToken, 0)
    }

    private fun toggleProgressBar(show: Boolean) {
        if(show) {
            binding.llProgress.visibility = View.VISIBLE
        } else {
            binding.llProgress.visibility = View.GONE
        }
    }

    private fun searchMusic(query: String) {
        searchViewModel.searchMusic(query).observe(this, Observer {apiResponse->
            toggleProgressBar(false)
            if (apiResponse.isSuccessful && apiResponse.body != null) {
                val searchResponse = apiResponse.body
                if (searchResponse.errorResponse != null) {
                    Timber.e("Error", searchResponse.errorResponse)
                    Toast.makeText(this, resources.getString(R.string.text_error_msg), Toast.LENGTH_SHORT).show()
                } else {
                    // all good, got our search response
                    searchViewModel.updateCache(searchResponse)
                }
            } else {
                Timber.e(apiResponse.errorMessage)
                Toast.makeText(this, resources.getString(R.string.text_error_msg), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initViewPager() {
        val viewPager: ViewPager2 = binding.viewPagerTypes
        val fragments = listOf(
            SearchAlbumFragment(),
            SearchArtistFragment(),
            SearchPlayListFragment(),
            SearchTrackFragment(),
            SearchShowFragment(),
            SearchEpisodeFragment(),
            SearchAudioBookFragment()
        )
        val adapter = ViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter

        val tabLayout: TabLayout = binding.tabLayout
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.selected_tab_color))
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val tabViewBinding = LayoutItemSearchTypeBinding.inflate(LayoutInflater.from(tabLayout.context), tabLayout, false)

            tabViewBinding.tvSearchType.text = searchViewModel.searchTabs[position]

            tab.customView = tabViewBinding.root
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tabTextView = tab?.customView?.findViewById<TextView>(R.id.tv_search_type)
                tabTextView?.setTextColor(resources.getColor(R.color.selected_tab_color, null))
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val tabTextView = tab?.customView?.findViewById<TextView>(R.id.tv_search_type)
                tabTextView?.setTextColor(resources.getColor(R.color.white, null))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Not needed
            }
        })

        tabLayout.getTabAt(0)?.customView?.findViewById<TextView>(R.id.tv_search_type)
            ?.setTextColor(resources.getColor(R.color.selected_tab_color, null))

        tabLayout.setPadding(resources.getDimensionPixelSize(R.dimen.tab_padding))
    }

}
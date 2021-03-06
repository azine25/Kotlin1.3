package com.geek.kotlin13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geek.kotlin13.databinding.ActivityFavoritesBinding
import com.geek.kotlin13.databinding.ActivityMainBinding

class FavoritesActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private lateinit var binding: ActivityFavoritesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
    }

    private fun initRecycler() {
        adapter = MainAdapter(null)
        intent.getIntegerArrayListExtra(MainActivity.IMAGE_KEY)?.let { adapter.setList(it) }
        binding.rvFavorite.adapter = adapter
    }
}
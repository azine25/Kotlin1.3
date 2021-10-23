package com.geek.kotlin13

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.renderscript.ScriptGroup
import com.geek.kotlin13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private var list = arrayListOf<Int>()
    private var secondList = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createList()
        initRecycler()
        btnFavorites()
    }


    private fun btnFavorites() {
        val intent = Intent(this, FavoritesActivity::class.java)
        binding.btnStart.setOnClickListener {
            intent.putExtra(IMAGE_KEY,secondList)
            startActivity(intent)
        }

    }

    private fun createList() {
        for (i in 1..30) {
            list.add(R.drawable.img)
            list.add(R.drawable.img1)
            list.add(R.drawable.img2)
        }
    }

    private fun initRecycler() {
        adapter = MainAdapter(object : MainAdapter.OnItemClick{

            override fun onClick(image: Int) {
                secondList.add(image)
            }

            override fun deleteClick(image: Int) {
                secondList.remove(image)
            }

        })
        adapter.setList(list)
        binding.rvMain.adapter = adapter

    }

    companion object{
        const val IMAGE_KEY= "Images"
    }

}
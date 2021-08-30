package com.example.cartaodevisitas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.cartaodevisitas.App
import com.example.cartaodevisitas.databinding.ActivityMainBinding
import com.example.cartaodevisitas.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusiness()
        insertListener()
    }

    private fun insertListener(){
        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddBusinessCardActivty::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)
        }
    }
    private fun getAllBusiness(){
        mainViewModel.getAll().observe(this){businessCards ->
            adapter.submitList(businessCards)
        }
    }
}
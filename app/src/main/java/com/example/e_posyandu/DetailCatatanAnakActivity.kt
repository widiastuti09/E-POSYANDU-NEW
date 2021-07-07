package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.adapters.ViewPagerAnakAdapter
import com.example.e_posyandu.databinding.ActivityDetailCatatanAnakBinding

class DetailCatatanAnakActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailCatatanAnakBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCatatanAnakBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun setupViewPager(){
        val loginViewPager = ViewPagerAnakAdapter(supportFragmentManager)
        binding.viewPager.adapter = loginViewPager
        binding.tabs.setupWithViewPager(binding.viewPager)
    }
}

package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.adapters.ViewPagerBumilAdapter
import com.example.e_posyandu.adapters.ViewPagerLansiaAdapter
import com.example.e_posyandu.databinding.ActivityDetailCatatanLansiaBinding

class DetailCatatanLansiaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailCatatanLansiaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCatatanLansiaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun setupViewPager(){
        val loginViewPager = ViewPagerLansiaAdapter(supportFragmentManager)
        binding.viewPagerLansia.adapter = loginViewPager
        binding.tabsLansia.setupWithViewPager(binding.viewPagerLansia)
    }
}
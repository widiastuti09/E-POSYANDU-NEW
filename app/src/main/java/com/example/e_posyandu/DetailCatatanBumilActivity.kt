package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.adapters.ViewPagerAnakAdapter
import com.example.e_posyandu.adapters.ViewPagerBumilAdapter
import com.example.e_posyandu.databinding.ActivityDetailCatatanBumilBinding

class DetailCatatanBumilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailCatatanBumilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCatatanBumilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun setupViewPager(){
        val loginViewPager = ViewPagerBumilAdapter(supportFragmentManager)
        binding.viewPagerBumil.adapter = loginViewPager
        binding.tabsBumil.setupWithViewPager(binding.viewPagerBumil)
    }
}
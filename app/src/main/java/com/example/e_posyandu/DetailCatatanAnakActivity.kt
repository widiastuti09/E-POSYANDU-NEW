package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.adapters.ViewPagerAnakAdapter
import com.example.e_posyandu.databinding.ActivityDetailCatatanAnakBinding
import com.example.e_posyandu.fragment.JadwalImunisasiAnakFragment
import com.example.e_posyandu.fragment.PenimbanganAnakFragment

class DetailCatatanAnakActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailCatatanAnakBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCatatanAnakBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun setupViewPager(){
        val userId = intent.getStringExtra("userIdAnak")
        val loginViewPager = ViewPagerAnakAdapter(supportFragmentManager)
        val fragmentPenimbangan = PenimbanganAnakFragment.getUserIdAnak(userId!!)
        loginViewPager.addFragment(JadwalImunisasiAnakFragment(), userId)
        loginViewPager.addFragment(fragmentPenimbangan, userId)
        binding.viewPager.adapter = loginViewPager
        binding.tabs.setupWithViewPager(binding.viewPager)
        println("UserId Detail = $userId")
    }



}

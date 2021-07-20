package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.adapters.ViewPagerLansiaAdapter
import com.example.e_posyandu.databinding.ActivityDetailCatatanLansiaBinding
import com.example.e_posyandu.fragment.JadwalLansiaFragment
import com.example.e_posyandu.fragment.PemeriksaanLansiaFragment

class DetailCatatanLansiaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailCatatanLansiaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCatatanLansiaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.title = "Detail Catatan Lansia"
        setupViewPager()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupViewPager(){
        val idLansia = intent.getStringExtra("idLansia")
        val lansiaViewPager = ViewPagerLansiaAdapter(supportFragmentManager)
        val fragmentPemeriksaan = PemeriksaanLansiaFragment.getIdLansia(idLansia!!)
        val fragmentJadwalLansia = JadwalLansiaFragment.getIdLansia(idLansia)
        lansiaViewPager.addFragment(fragmentPemeriksaan, idLansia)
        lansiaViewPager.addFragment(fragmentJadwalLansia, idLansia)
        binding.viewPagerLansia.adapter = lansiaViewPager
        binding.tabsLansia.setupWithViewPager(binding.viewPagerLansia)
        println("Id Lansia = $idLansia")
    }
}
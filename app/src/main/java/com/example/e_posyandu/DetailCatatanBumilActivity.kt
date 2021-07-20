package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.adapters.ViewPagerBumilAdapter
import com.example.e_posyandu.databinding.ActivityDetailCatatanBumilBinding
import com.example.e_posyandu.fragment.BumilResikoTinggiFragment
import com.example.e_posyandu.fragment.PemeriksaanBumilFragment
import com.example.e_posyandu.fragment.JadwalBumilFragment

class DetailCatatanBumilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailCatatanBumilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCatatanBumilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.title = "Detail Catatan Ibu Hamil"
        setupViewPager()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupViewPager(){
        val idBumil = intent.getStringExtra("idBumil")
        val fragmentJadwalBumil = JadwalBumilFragment.getIdbumil(idBumil!!)
        val fragmentPemeriksaanBumil = PemeriksaanBumilFragment.getIdBumil(idBumil)
        val fragmentBumilResikoTinggi = BumilResikoTinggiFragment.getIdbumil(idBumil)
        val bumilViewPager = ViewPagerBumilAdapter(supportFragmentManager)
        bumilViewPager.addFragment(fragmentJadwalBumil, idBumil)
        bumilViewPager.addFragment(fragmentPemeriksaanBumil, idBumil)
        bumilViewPager.addFragment(fragmentBumilResikoTinggi, idBumil)
        binding.viewPagerBumil.adapter = bumilViewPager
        binding.tabsBumil.setupWithViewPager(binding.viewPagerBumil)
    }
}
package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.adapters.ViewPagerBumilAdapter
import com.example.e_posyandu.databinding.ActivityDetailCatatanBumilBinding
import com.example.e_posyandu.fragment.PemeriksaanBumilFragment
import com.example.e_posyandu.fragment.PenimbanganBumilFragment

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
        val fragmentPenimabanganBumil = PenimbanganBumilFragment.getIdbumil(idBumil!!)
        val fragmentPemeriksaanBumil = PemeriksaanBumilFragment.getIdBumil(idBumil)
        val bumilViewPager = ViewPagerBumilAdapter(supportFragmentManager)
        bumilViewPager.addFragment(fragmentPenimabanganBumil, idBumil)
        bumilViewPager.addFragment(fragmentPemeriksaanBumil, idBumil)
        binding.viewPagerBumil.adapter = bumilViewPager
        binding.tabsBumil.setupWithViewPager(binding.viewPagerBumil)
    }
}
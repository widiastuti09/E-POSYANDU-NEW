package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.databinding.ActivityDetailRestiBumilBinding
import com.example.e_posyandu.models.IbuHamilResikoTinggi

class DetailRestiBumilActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailRestiBumilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRestiBumilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.title = "Detail Resiko Tinggi"
        attachToView()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getRestiBumilDetail() : IbuHamilResikoTinggi = intent.getParcelableExtra("DETAIL_RESTI")!!

    private fun attachToView(){
        binding.tvnamaBumil.text = getRestiBumilDetail().id_ibu
        binding.tvAsuransi.text = getRestiBumilDetail().asuransi
        binding.tvUmurKehamilan.text = getRestiBumilDetail().umur_hamil + " Bulan"
        binding.tvGPA.text = getRestiBumilDetail().gpa
        binding.tvResikoTinggi.text = getRestiBumilDetail().resiko_tinggi
        binding.tvHPL.text = getRestiBumilDetail().hpl
        binding.tvWaliBumil.text = getRestiBumilDetail().wali_bumil
    }
}
package com.example.e_posyandu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.databinding.ActivityDetailPemeriksaanLansiaBinding
import com.example.e_posyandu.models.PemeriksaanLansia

class DetailPemeriksaanLansiaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPemeriksaanLansiaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPemeriksaanLansiaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Pemeriksaan"
        actionbar.setDisplayHomeAsUpEnabled(true)
        showDetailToView()
        intentButton()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun intentButton(){
        binding.btnPeringatan.setOnClickListener {
            val intent = Intent(this@DetailPemeriksaanLansiaActivity, ReminderLansiaActivity::class.java).apply{
                putExtra("PENYAKIT_LANSIA", getDetailPemeriksaanLansia().penyakit)
            };
            startActivity(intent)
        }
    }

    private fun getDetailPemeriksaanLansia() : PemeriksaanLansia  = intent.getParcelableExtra("DetailpemeriksaanLansia")!!

    private fun showDetailToView(){
        binding.tvTanggal.setText(getDetailPemeriksaanLansia().tanggal_periksa)
        binding.tvBeratBadan.setText(getDetailPemeriksaanLansia().berat_badan+ " Kg")
        binding.tvTinggiBadan.setText(getDetailPemeriksaanLansia().tinggi_badan+ " Cm")
        binding.tvLingkarPinggang.setText(getDetailPemeriksaanLansia().lingkar_pinggang+ " Cm")
        binding.tvTekananDarah.setText(getDetailPemeriksaanLansia().tekanan_darah)
        binding.tvGlukosa.setText(getDetailPemeriksaanLansia().glukosa_darah)
        binding.tvLemakTubuh.setText(getDetailPemeriksaanLansia().lemak_tubuh)
        binding.tvLemakPerut.setText(getDetailPemeriksaanLansia().lemak_perut)
        binding.tvIMT.setText(getDetailPemeriksaanLansia().imt)
        binding.tvKolesterol.setText(getDetailPemeriksaanLansia().kolestrol)
        binding.tvAsamUrat.setText(getDetailPemeriksaanLansia().asam_urat)
        binding.tvMerokok.setText(getDetailPemeriksaanLansia().merokok)
        binding.tvKeterangan.setText(getDetailPemeriksaanLansia().keterangan)
        binding.tvPenyakit.setText(getDetailPemeriksaanLansia().penyakit)
    }
}
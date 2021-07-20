package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.databinding.ActivityDetailJadwalAnakBinding
import com.example.e_posyandu.models.JadwalAnak

class DetailJadwalAnakActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailJadwalAnakBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailJadwalAnakBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.title = "Detail Jadwal"
        showDataToView()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getDetailJadwal(): JadwalAnak = intent.getParcelableExtra("jadwalAnak")!!

    private fun showDataToView(){
        binding.tvtanggal.setText(getDetailJadwal().tanggal)
        binding.tvwaktu.setText(getDetailJadwal().waktu)
        binding.tvStatus.setText(getDetailJadwal().status)
        binding.tvKeterangan.setText(getDetailJadwal().keterangan)
    }
}
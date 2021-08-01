package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.databinding.ActivityDetailJadwalLansiaBinding
import com.example.e_posyandu.models.Jadwal
import com.example.e_posyandu.models.JadwalLansia

class DetailJadwalLansiaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailJadwalLansiaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailJadwalLansiaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.title = "Detail Jadwal Lansia"
        showDataToView()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getDetailJadwal(): Jadwal = intent.getParcelableExtra("jadwal")!!

    private fun showDataToView(){
        binding.tvtanggal.setText(getDetailJadwal().tanggal)
        binding.tvwaktu.setText(getDetailJadwal().waktu)
        binding.tvStatus.setText(getDetailJadwal().status)
        binding.tvKeterangan.setText(getDetailJadwal().keterangan)
    }
}
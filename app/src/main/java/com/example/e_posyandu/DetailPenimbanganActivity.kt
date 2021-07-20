package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.databinding.ActivityDetailPenimbanganBinding
import com.example.e_posyandu.models.PenimbanganAnak

class DetailPenimbanganActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPenimbanganBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPenimbanganBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.title = "Detail Penimbangan"
        showDataToView()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getPenimbangan() : PenimbanganAnak = intent.getParcelableExtra("penimbangan")!!
    private fun showDataToView(){
        binding.tvTanggal.setText(getPenimbangan().tanggal)
        binding.tvJenisImunisasi.setText(getPenimbangan().jenis_imunisasi)
        binding.tvBeratBadan.setText(getPenimbangan().beratbadan + " Kg")
        binding.tvIMP.setText(getPenimbangan().imp)
        binding.tvKIA.setText(getPenimbangan().kia)
        binding.tvJenisVitamin.setText(getPenimbangan().vitamin)
    }
}
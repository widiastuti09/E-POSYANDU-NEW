package com.example.e_posyandu

import android.content.Intent
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
        intentButton()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun intentButton(){
        binding.btnPeringatan.setOnClickListener {
            val intent = Intent(this@DetailPenimbanganActivity, ReminderBalitaActivity::class.java).apply{
                putExtra("PENYAKIT_BALITA", getPenimbangan().penyakit)
            };
            startActivity(intent)
        }
    }

    private fun getPenimbangan() : PenimbanganAnak = intent.getParcelableExtra("penimbangan")!!
    private fun showDataToView(){
        binding.tvTanggal.setText(getPenimbangan().tanggal)
        binding.tvJenisImunisasi.setText(getPenimbangan().jenis_imunisasi)
        binding.tvBeratBadan.setText(getPenimbangan().beratbadan + " Kg")
        binding.tvIMP.setText(getPenimbangan().imp)
        binding.tvKIA.setText(getPenimbangan().kia)
        binding.tvJenisVitamin.setText(getPenimbangan().vitamin)
        if(getPenimbangan().penyakit == null){
            binding.tvPenyakit.setText("Tidak ada")
        }else{
            binding.tvPenyakit.setText(getPenimbangan().penyakit)
        }

    }
}
package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.databinding.ActivityDetailPemeriksaanBumilBinding
import com.example.e_posyandu.models.IbuHamil
import com.example.e_posyandu.models.PemeriksaanBumil

class DetailPemeriksaanBumilActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailPemeriksaanBumilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPemeriksaanBumilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.title = "Detail Pemeriksaan Ibu Hamil"
        attacthToView()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getDetailPemeriksaanBumil () : PemeriksaanBumil = intent.getParcelableExtra("PEMERIKSAAN_BUMIL")!!

    private fun attacthToView(){
        binding.tvnamaBumil.text = getDetailPemeriksaanBumil().id_ibu
        binding.tvBeratBadan.text = getDetailPemeriksaanBumil().beratbadan + " Kg"
        binding.tvTinggiBadan.text = getDetailPemeriksaanBumil().tinggibadan + " Cm"
        binding.tvHemoglobin.text = getDetailPemeriksaanBumil().hemoglobin_atas +"/"+getDetailPemeriksaanBumil().hemoglobin_bawah
        binding.tvHTP.text = getDetailPemeriksaanBumil().htp
        binding.tvHPHT.text = getDetailPemeriksaanBumil().hpht
        binding.tvHamilKe.text = getDetailPemeriksaanBumil().hamilke
        binding.tvPersalinanKe.text = getDetailPemeriksaanBumil().persalinanke
        binding.tvJumlahKeguguran.text = getDetailPemeriksaanBumil().keguguranke

    }
}
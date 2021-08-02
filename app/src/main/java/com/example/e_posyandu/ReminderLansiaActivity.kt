package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_posyandu.adapters.ReminderBalitaActivityAdapter
import com.example.e_posyandu.databinding.ActivityReminderLansiaBinding

import com.example.e_posyandu.utilities.ReminderLansia

class ReminderLansiaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReminderLansiaBinding

    private lateinit var adapterReminder : ReminderBalitaActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReminderLansiaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        attachToRecycler()
        attachToRecyclerPenyebab()
        parsePengertian()
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.title = "Peringatan"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getPenyakit() : String = intent.getStringExtra("PENYAKIT_LANSIA").toString();

    private fun attachToRecycler(){
        if(getPenyakit() == "Kolesterol"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderLansia.kolesterol)
        }else if(getPenyakit() == "Hipertensi"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderLansia.hipertensi)
        }else if(getPenyakit() == "Diabetes"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderLansia.diabetes)
        }else if(getPenyakit() == "Asam urat"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderLansia.asamUrat)
        }else if(getPenyakit() == "Osteoporosis"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderLansia.osteoporosis)
        }else if(getPenyakit() == "Encok") {
            adapterReminder = ReminderBalitaActivityAdapter(ReminderLansia.encok)
        }
        else{
            binding.rvReminderBalita.visibility = View.GONE
            binding.textView.visibility = View.GONE
            adapterReminder = ReminderBalitaActivityAdapter(arrayOf())
            binding.terimakasih.visibility = View.VISIBLE
        }

        binding.rvReminderBalita.apply {
            layoutManager = LinearLayoutManager(this@ReminderLansiaActivity)
            adapter = adapterReminder
        }
    }

    private fun attachToRecyclerPenyebab() {
        if(getPenyakit() == "Kolesterol"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderLansia.penyebabKolesterol)
        }else if(getPenyakit() == "Hipertensi"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderLansia.penyebabHipertensi)
        }else if(getPenyakit() == "Diabetes"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderLansia.penyebabDiabetes)
        }else if(getPenyakit() == "Asam urat"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderLansia.penyebabAsamUrat)
        }else if(getPenyakit() == "Osteoporosis"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderLansia.penyebabOsteoporosis)
        }else if(getPenyakit() == "Encok"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderLansia.penyebabEncok)
        }
        else{
            binding.rvpenyebab.visibility = View.GONE
            binding.tvPenyebab.visibility = View.GONE
            adapterReminder = ReminderBalitaActivityAdapter(arrayOf())
        }

        binding.rvpenyebab.apply {
            layoutManager = LinearLayoutManager(this@ReminderLansiaActivity)
            adapter = adapterReminder
        }
    }

    private fun parsePengertian() {
        if(getPenyakit() == "Kolesterol"){
            binding.tvPengertian.text = ReminderLansia.pengertianKolesterol
        }else if(getPenyakit() == "Hipertensi"){
            binding.tvPengertian.text = ReminderLansia.pengertianHipertensi
        }else if(getPenyakit() == "Diabetes"){
            binding.tvPengertian.text = ReminderLansia.pengertianDiabetes
        }else if(getPenyakit() == "Asam urat"){
            binding.tvPengertian.text = ReminderLansia.pengertianAsamUrat
        }else if(getPenyakit() == "Osteoporosis"){
            binding.tvPengertian.text = ReminderLansia.pengertianOsteoporosis
        }else if(getPenyakit() == "Encok"){
            binding.tvPengertian.text = ReminderLansia.pengertianEncok
        }
        else{
            binding.tvPengertian.visibility = View.GONE
        }
    }

}
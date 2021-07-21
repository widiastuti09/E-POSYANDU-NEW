package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_posyandu.adapters.ReminderBalitaActivityAdapter
import com.example.e_posyandu.databinding.ActivityReminderLansiaBinding
import com.example.e_posyandu.utilities.ReminderBalita
import com.example.e_posyandu.utilities.ReminderLansia

class ReminderLansiaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReminderLansiaBinding

    private lateinit var adapterReminder : ReminderBalitaActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReminderLansiaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        attachToRecycler()
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
        }else{
            adapterReminder = ReminderBalitaActivityAdapter(arrayOf("Jagalah kesehatan selalu"))
        }

        binding.rvReminderBalita.apply {
            layoutManager = LinearLayoutManager(this@ReminderLansiaActivity)
            adapter = adapterReminder
        }
    }

}
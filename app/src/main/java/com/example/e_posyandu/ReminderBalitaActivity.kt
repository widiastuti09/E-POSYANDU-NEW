package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_posyandu.adapters.ReminderBalitaActivityAdapter
import com.example.e_posyandu.databinding.ActivityReminderBalitaBinding
import com.example.e_posyandu.utilities.ReminderBalita

class ReminderBalitaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReminderBalitaBinding


    private lateinit var adapterReminder : ReminderBalitaActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReminderBalitaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        attachToRecycler()
        attachToRecyclerDarurat()

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.title = "Peringatan"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getPenyakit() : String = intent.getStringExtra("PENYAKIT_BALITA").toString();

    private fun attachToRecycler(){
        if(getPenyakit() == "Demam"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderBalita.arrayDemam,)
        }else if(getPenyakit() == "Batuk"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderBalita.arrayBatuk)
        }else if(getPenyakit() == "Diare"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderBalita.arrayDiare)
        }else if(getPenyakit() == "Luka dan Sakit Kulit"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderBalita.arrayLuka)
        }else{
            adapterReminder = ReminderBalitaActivityAdapter(ReminderBalita.arrayKosong)
        }

        binding.rvReminderBalita.apply {
            layoutManager = LinearLayoutManager(this@ReminderBalitaActivity)
            adapter = adapterReminder
        }
    }

    private fun attachToRecyclerDarurat(){
        if(getPenyakit() == "Demam"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderBalita.daruratDemam,)
        }else if(getPenyakit() == "Batuk"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderBalita.daruratBatuk)
        }else if(getPenyakit() == "Diare"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderBalita.daruratDiare)
        }else if(getPenyakit() == "Luka dan Sakit Kulit"){
            adapterReminder = ReminderBalitaActivityAdapter(ReminderBalita.daruratLuka)
        }else{
            adapterReminder = ReminderBalitaActivityAdapter(arrayOf())
        }

        binding.rvReminderBalitaDarurat.apply {
            layoutManager = LinearLayoutManager(this@ReminderBalitaActivity)
            adapter = adapterReminder
        }
    }
}
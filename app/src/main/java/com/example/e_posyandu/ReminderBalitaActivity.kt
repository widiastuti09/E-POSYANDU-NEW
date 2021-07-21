package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_posyandu.adapters.ReminderBalitaActivityAdapter
import com.example.e_posyandu.databinding.ActivityReminderBalitaBinding

class ReminderBalitaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReminderBalitaBinding

    var arrayDemam = arrayOf("JIka masih menyusu, berikan ASI lebih sering",
        "Beri minum lebih sering dan lebih banyak",
        "Jangan diselimuti atau diberi baju tebal",
        "Kompres dengan air biasa"
        );

    var arrayLuka = arrayOf(
        "Beri obat merah atau povidon iodine",
        "Tutup dengan kain bersih",
        "Jangan dibubuhi ramuan apapun",
    );

    var arrayBatuk = arrayOf(
        "Jika masih menyusu, berikan ASI lebih sering",
        "Beri minum air matang lebih sering",
        "Jika umurnya lebih dari 1tahun beri kecap atau madu lalu dicampur air jeruk nipis",
        "Jauhkkan dari asap apapun"
    );

    var arrayDiare = arrayOf(
        "Berikan segera cairan oralit setiap anak BAB",
        "Jika anak masih menyusu, terus berikan ASI dan MP-ASI",
        "Jangan beri obat apapun kecuali dari petugas kesehatan"
    );

    var arrayKosong = arrayOf(
        "Terima kasih telah menjaga anak anda"
    );

    private lateinit var adapterReminder : ReminderBalitaActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReminderBalitaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        attachToRecycler()
    }

    private fun getPenyakit() : String = intent.getStringExtra("PENYAKIT_BALITA").toString();

    private fun attachToRecycler(){
        if(getPenyakit() == "Demam"){
            adapterReminder = ReminderBalitaActivityAdapter(arrayDemam, this@ReminderBalitaActivity)
        }else if(getPenyakit() == "Batuk"){
            adapterReminder = ReminderBalitaActivityAdapter(arrayBatuk, this@ReminderBalitaActivity)
        }else if(getPenyakit() == "Diare"){
            adapterReminder = ReminderBalitaActivityAdapter(arrayDiare, this@ReminderBalitaActivity)
        }else if(getPenyakit() == "Luka dan Sakit Kulit"){
            adapterReminder = ReminderBalitaActivityAdapter(arrayLuka, this@ReminderBalitaActivity)
        }else{
            adapterReminder = ReminderBalitaActivityAdapter(arrayKosong, this@ReminderBalitaActivity)
        }

        binding.rvReminderBalita.apply {
            layoutManager = LinearLayoutManager(this@ReminderBalitaActivity)
            adapter = adapterReminder
        }
    }
}
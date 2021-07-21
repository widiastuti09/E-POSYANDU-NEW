package com.example.e_posyandu.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.e_posyandu.databinding.ItemPenimbanganAnakBinding
import com.example.e_posyandu.models.PenimbanganAnak
import java.time.format.DateTimeFormatter

class PenimbanganAnakAdapter (private val penimbangan : List<PenimbanganAnak>, private val listener : onPenimbanganAnakListener): RecyclerView.Adapter<PenimbanganAnakAdapter.MyViewholder>(){

    inner class MyViewholder(val binding: ItemPenimbanganAnakBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        return MyViewholder(ItemPenimbanganAnakBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        holder.binding.apply{
            val tanggal = penimbangan[position].tanggal
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyy")
            tvTanggal.text = tanggal!!.format(formatter)
        }
        holder.itemView.setOnClickListener {
            listener.onDetailClick(penimbangan[position])
        }
    }

    override fun getItemCount(): Int {
        return penimbangan.size
    }
}

interface onPenimbanganAnakListener{
    fun onDetailClick(penimbangan : PenimbanganAnak)
}
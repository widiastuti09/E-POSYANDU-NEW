package com.example.e_posyandu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_posyandu.databinding.ItemJadwalBumilBinding
import com.example.e_posyandu.models.JadwalBumil

class JadwalBumilAdapter(private var jadwal : List<JadwalBumil>, private val listener : JadwalBumilListener): RecyclerView.Adapter<JadwalBumilAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding : ItemJadwalBumilBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemJadwalBumilBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvTanggal.text = jadwal[position].tanggal
        holder.binding.tvStatus.text = jadwal[position].status
        holder.itemView.setOnClickListener {
            listener.onDetailJadwalBumil(jadwal[position])
        }
    }

    override fun getItemCount(): Int {
        return jadwal.size
    }
}

interface JadwalBumilListener{
    fun onDetailJadwalBumil(jadwalBumil : JadwalBumil)
}
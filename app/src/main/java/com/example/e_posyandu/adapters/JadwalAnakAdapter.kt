package com.example.e_posyandu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_posyandu.databinding.ItemJadwalAnakBinding
import com.example.e_posyandu.models.JadwalAnak

class JadwalAnakAdapter(private var jadwal : List<JadwalAnak>, private val listener : JadwalAnakListener) : RecyclerView.Adapter<JadwalAnakAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding : ItemJadwalAnakBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemJadwalAnakBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvTanggal.text = jadwal[position].tanggal
        holder.binding.tvStatus.text = jadwal[position].status
        holder.itemView.setOnClickListener {
            listener.onDetailJadwalAnak(jadwal[position])
        }

    }

    override fun getItemCount(): Int {
        return jadwal.size
    }
}

interface JadwalAnakListener{
    fun onDetailJadwalAnak(jadwalAnak : JadwalAnak)
}
package com.example.e_posyandu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_posyandu.databinding.ItemJadwalLansiaBinding
import com.example.e_posyandu.models.Jadwal
import com.example.e_posyandu.models.JadwalLansia

class JadwalLansiaAdapter (private var jadwal : List<Jadwal>, private val listener : JadwalLansiaListener) : RecyclerView.Adapter<JadwalLansiaAdapter.MyViewHolder>(){

    inner class MyViewHolder(val binding : ItemJadwalLansiaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemJadwalLansiaBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvTanggal.text = jadwal[position].tanggal
        holder.binding.tvStatus.text = jadwal[position].status
        holder.itemView.setOnClickListener {
            listener.onDetailJadwalLansia(jadwal[position])
        }
    }

    override fun getItemCount(): Int {
        return jadwal.size
    }
}

interface JadwalLansiaListener{
    fun onDetailJadwalLansia(jadwalLansia : Jadwal)
}
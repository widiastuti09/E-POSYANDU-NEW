package com.example.e_posyandu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_posyandu.databinding.ItemJadwalLansiaBinding
import com.example.e_posyandu.databinding.ItemStatusImunisasiBinding
import com.example.e_posyandu.models.Jadwal
import com.example.e_posyandu.models.StatusImunisasi

class StatusImunisasiAdapter(private var statusImunisasi : List<StatusImunisasi>, private val listener : onStatusImunisasiListener) :
    RecyclerView.Adapter<StatusImunisasiAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding : ItemStatusImunisasiBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemStatusImunisasiBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return statusImunisasi.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvTanggal.text = statusImunisasi[position].tanggal
        holder.binding.tvStatus.text = statusImunisasi[position].status
        holder.binding.tvJenisImunisasi.text = statusImunisasi[position].jenis
        holder.itemView.setOnClickListener {
            listener.onStatusImunisasi(statusImunisasi[position])
        }
    }

}

interface onStatusImunisasiListener{
    fun onStatusImunisasi(statusImunisasi : StatusImunisasi)
}
package com.example.e_posyandu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_posyandu.databinding.ItemPemeriksaanLansiaBinding
import com.example.e_posyandu.models.PemeriksaanLansia

class PemeriksaanLansiaAdapter (private val pemeriksaan : List<PemeriksaanLansia>, private val listener: onPemeriksaanLansiaListener) : RecyclerView.Adapter<PemeriksaanLansiaAdapter.MyViewholder>(){

    inner class MyViewholder(val binding: ItemPemeriksaanLansiaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        return MyViewholder(ItemPemeriksaanLansiaBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        holder.binding.tvTanggal.text = pemeriksaan[position].tanggal_periksa
        holder.itemView.setOnClickListener {
            listener.onDetailClick(pemeriksaan[position])
        }
    }

    override fun getItemCount(): Int {
        return pemeriksaan.size
    }
}

interface onPemeriksaanLansiaListener{
    fun onDetailClick( pemeriksaan : PemeriksaanLansia )
}
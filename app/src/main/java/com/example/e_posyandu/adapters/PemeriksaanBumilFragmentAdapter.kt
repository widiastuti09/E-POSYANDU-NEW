package com.example.e_posyandu.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.e_posyandu.databinding.ItemKesehatanBumilBinding
import com.example.e_posyandu.models.PemeriksaanBumil
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PemeriksaanBumilFragmentAdapter(private var pemeriksaan : List<PemeriksaanBumil>, private val listener : onPemeriksaanBumilListener) : RecyclerView.Adapter<PemeriksaanBumilFragmentAdapter.MyViewHolder>(){
    class MyViewHolder(val binding : ItemKesehatanBumilBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemKesehatanBumilBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.binding.tvTanggal.text = pemeriksaan[position].created_at!!.substring(0,10)
        holder.itemView.setOnClickListener {
            listener.onDetailClick(pemeriksaan[position])
        }
    }

    override fun getItemCount() = pemeriksaan.size
}

interface onPemeriksaanBumilListener {
    fun onDetailClick( pemeriksaan : PemeriksaanBumil)
}


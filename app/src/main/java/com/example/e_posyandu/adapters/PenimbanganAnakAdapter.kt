package com.example.e_posyandu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_posyandu.databinding.ItemPenimbanganAnakBinding
import com.example.e_posyandu.models.PenimbanganAnak

class PenimbanganAnakAdapter (private val penimbangan : List<PenimbanganAnak>, private val listener : onPenimbanganAnakListener): RecyclerView.Adapter<PenimbanganAnakAdapter.MyViewholder>(){

    inner class MyViewholder(val binding: ItemPenimbanganAnakBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        return MyViewholder(ItemPenimbanganAnakBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        holder.binding.apply{
            tvTanggal.text = penimbangan[position].tanggal
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
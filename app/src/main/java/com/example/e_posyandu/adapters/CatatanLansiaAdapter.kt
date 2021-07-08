package com.example.e_posyandu.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_posyandu.DetailCatatanLansiaActivity
import com.example.e_posyandu.R
import com.example.e_posyandu.models.Lansia
import kotlinx.android.synthetic.main.item_daftar_lansia.view.*

class CatatanLansiaAdapter(private var lansia : List<Lansia>, private var context: Context): RecyclerView.Adapter<CatatanLansiaAdapter.Myholder>() {

    inner class Myholder (itemView : View): RecyclerView.ViewHolder(itemView){
        fun bind(lansia : Lansia, context: Context){
            itemView.tvNamaLansia.text = lansia.nama
            itemView.setOnClickListener {
                context.startActivity(Intent(context, DetailCatatanLansiaActivity::class.java).apply{
                    putExtra("idLansia", lansia.id)
                })
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myholder {
        return Myholder(LayoutInflater.from(context).inflate(R.layout.item_daftar_lansia, parent, false))
    }

    override fun onBindViewHolder(holder: Myholder, position: Int) {
        holder.bind(lansia[position], context)
    }

    override fun getItemCount(): Int {
        return lansia.size
    }
}
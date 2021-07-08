package com.example.e_posyandu.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_posyandu.DetailCatatanAnakActivity
import com.example.e_posyandu.R
import com.example.e_posyandu.models.Anak
import kotlinx.android.synthetic.main.item_daftar_anak.view.*

class CatatanAnakAdapter(private var anak : List<Anak>, private var context : Context) : RecyclerView.Adapter<CatatanAnakAdapter.MyHolder>() {

    inner class MyHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(anak : Anak, context: Context){
            itemView.tvNamaAnak.text = anak.namabalita
            itemView.setOnClickListener {
                context.startActivity(Intent(context, DetailCatatanAnakActivity::class.java).apply{
                    putExtra("idAnak", anak.id)
                })
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatatanAnakAdapter.MyHolder {
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_daftar_anak, parent, false))
    }

    override fun onBindViewHolder(holder: CatatanAnakAdapter.MyHolder, position: Int) = holder.bind(anak[position], context)

    override fun getItemCount(): Int = anak.size
}
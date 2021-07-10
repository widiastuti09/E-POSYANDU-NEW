package com.example.e_posyandu.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_posyandu.DetailCatatanBumilActivity
import com.example.e_posyandu.R
import com.example.e_posyandu.models.IbuHamil
import kotlinx.android.synthetic.main.item_daftar_bumil.view.*

class CatatanBumilAdapter(private var bumil : List<IbuHamil>, private var context: Context) : RecyclerView.Adapter<CatatanBumilAdapter.MyHolder>() {
    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(bumil : IbuHamil, context: Context){
            itemView.tvNamaBumil.text = bumil.nama
            itemView.setOnClickListener {
                context.startActivity(Intent(context, DetailCatatanBumilActivity::class.java).apply{
                    putExtra("idBumil", bumil.id)
                })
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_daftar_bumil, parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) = holder.bind(bumil[position], context)

    override fun getItemCount(): Int = bumil.size
}
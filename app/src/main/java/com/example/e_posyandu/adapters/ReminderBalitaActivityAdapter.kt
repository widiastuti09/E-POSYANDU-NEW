package com.example.e_posyandu.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_posyandu.R
import com.example.e_posyandu.databinding.ItemReminderBalitaBinding
import kotlinx.android.synthetic.main.item_reminder_balita.view.*

class ReminderBalitaActivityAdapter(private var array : Array<String>) : RecyclerView.Adapter<ReminderBalitaActivityAdapter.ViewHolder>() {

    inner class ViewHolder(val binding : ItemReminderBalitaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemReminderBalitaBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var no : Int = position + 1
        holder.binding.tvNo.text = no.toString() + ". "
        holder.binding.tvReminder.text = array[position]
    }

    override fun getItemCount() = array.size
}
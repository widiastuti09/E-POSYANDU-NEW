package com.example.e_posyandu.contracts

import com.example.e_posyandu.models.Jadwal
import com.example.e_posyandu.models.JadwalAnak

interface JadwalAnakFragmentContract {
    interface View {
        fun attacthToRecycler(jadwalAnak : List<Jadwal>)
        fun showLoading()
        fun hideLoading()
        fun showToast(message : String)
    }

    interface presenter {
        fun getJadwalAnak(token : String)
        fun destroy()
    }

}
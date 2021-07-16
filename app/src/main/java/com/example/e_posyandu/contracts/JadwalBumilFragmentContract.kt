package com.example.e_posyandu.contracts

import com.example.e_posyandu.models.JadwalAnak
import com.example.e_posyandu.models.JadwalBumil

interface JadwalBumilFragmentContract {
    interface View {
        fun attacthToRecycler(jadwalBumil : List<JadwalBumil>)
        fun showLoading()
        fun hideLoading()
        fun showToast(message : String)
    }

    interface presenter {
        fun getJadwalBumil(token : String)
        fun destroy()
    }

}
package com.example.e_posyandu.contracts

import com.example.e_posyandu.models.JadwalLansia

interface JadwalLansiaFragmentContract {
    interface View {
        fun attacthToRecycler(jadwalLansia : List<JadwalLansia>)
        fun showLoading()
        fun hideLoading()
        fun showToast(message : String)
    }

    interface presenter {
        fun getJadwalLansia(token : String)
        fun destroy()
    }

}
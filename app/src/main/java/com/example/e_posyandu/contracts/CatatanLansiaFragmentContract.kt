package com.example.e_posyandu.contracts

import com.example.e_posyandu.models.Lansia

interface CatatanLansiaFragmentContract {
    interface View {
        fun attacthToRecycler(lansia : List<Lansia>)
        fun showLoading()
        fun hideLoading()
        fun showToast(message : String)
    }

    interface presenter {
        fun getDataLansia(token : String)
        fun destroy()
    }
}
package com.example.e_posyandu.contracts

import com.example.e_posyandu.models.PemeriksaanBumil


interface PemeriksaanBumilFragmentContract {
    interface View {
        fun attacthToView(pemeriksaanBumil : List<PemeriksaanBumil>)
        fun showLoading()
        fun hideLoading()
        fun showToast(message : String)
    }

    interface presenter {
        fun getDataPemeriksaanBumil(token : String, idBumil : String)
        fun destroy()
    }
}
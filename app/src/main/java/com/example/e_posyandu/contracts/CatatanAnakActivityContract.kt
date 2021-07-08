package com.example.e_posyandu.contracts

import com.example.e_posyandu.models.Anak

interface CatatanAnakActivityContract {
    interface View {
        fun attacthToRecycler(anak : List<Anak>)
        fun showLoading()
        fun hideLoading()
        fun showToast(message : String)
    }

    interface presenter {
        fun getDataAnak(token : String)
        fun destroy()
    }
}
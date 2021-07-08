package com.example.e_posyandu.contracts

import com.example.e_posyandu.models.IbuHamil

interface CatatanBumilActivityContract {
    interface View {
        fun attacthToRecycler(bumil : List<IbuHamil>)
        fun showLoading()
        fun hideLoading()
        fun showToast(message : String)
    }

    interface presenter {
        fun getDataIbuHamil(token : String)
        fun destroy()
    }
}
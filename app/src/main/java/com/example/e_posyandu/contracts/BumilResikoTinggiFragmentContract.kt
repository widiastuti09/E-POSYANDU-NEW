package com.example.e_posyandu.contracts

import com.example.e_posyandu.models.IbuHamil
import com.example.e_posyandu.models.IbuHamilResikoTinggi

interface BumilResikoTinggiFragmentContract {
    interface View {
        fun attacthToRecycler(bumilResikoTinggi : List<IbuHamilResikoTinggi>)
        fun showLoading()
        fun hideLoading()
        fun emptyData()
        fun showToast(message : String)
    }

    interface presenter {
        fun getDataIbuHamilResikoTinggi(token : String, idBumil : String)
        fun destroy()
    }

}
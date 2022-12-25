package com.example.e_posyandu.contracts

import com.example.e_posyandu.models.Jadwal
import com.example.e_posyandu.models.StatusImunisasi

interface StatusImunisasiFragmentContract {
        interface View {
            fun attacthToRecycler(statusImunisasi : List<StatusImunisasi>)
            fun showLoading()
            fun hideLoading()
            fun showToast(message : String)
        }

        interface presenter {
            fun getStatusImunisasi(token : String, idAnak: String)
            fun destroy()
        }
}
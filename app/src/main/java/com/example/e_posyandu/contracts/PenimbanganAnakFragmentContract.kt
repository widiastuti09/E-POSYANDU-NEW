package com.example.e_posyandu.contracts


import com.example.e_posyandu.models.PenimbanganAnak

interface PenimbanganAnakFragmentContract {
    interface View {
        fun attacthToRecycler(penimbangan : List<PenimbanganAnak>)
        fun showLoading()
        fun hideLoading()
        fun showToast(message : String)
    }

    interface presenter {
        fun getDataPenimbanganAnak(token : String, idAnak : String)
        fun destroy()
    }
}
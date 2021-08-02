package com.example.e_posyandu.contracts

import android.content.Context
import com.example.e_posyandu.models.Anak

interface EditProfileActivityContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showToast(message : String)
    }

    interface presenter {
        fun changeDataProfile(token : String, id : String, name : String, email : String, password : String, context: Context)
        fun changeDataProfileWithoutPassword(token : String, id : String, name : String, email : String, context: Context)
        fun destroy()
    }
}
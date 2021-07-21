package com.example.e_posyandu.contracts

import android.content.Context
import com.example.e_posyandu.models.User

interface LoginActivityContract {
    interface LoginActivityView {
        fun showToast(message : String)
        fun successLogin(user : User)
        fun showLoading()
        fun hideLoading()
    }

    interface LoginActivityPresenter {
        fun login(email : String, password: String, context : Context)
        fun saveDeviceToken(token : String, device_token : String)
        fun destroy()
    }
}
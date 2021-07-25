package com.example.e_posyandu.contracts

import android.content.Context
import com.example.e_posyandu.models.User

interface ResetPasswordContract {
    interface ResetPasswordActivityView {
        fun showToast(message : String)
        fun successResetPasword()
        fun showLoading()
        fun hideLoading()
    }

    interface ResetPasswordActivityPresenter {
        fun resetPassword(email : String)
        fun destroy()
    }
}
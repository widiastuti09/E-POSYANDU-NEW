package com.example.e_posyandu.contracts

import android.content.Context
import com.example.e_posyandu.models.User

interface ChagePasswordActivityContract {
    interface ChagePasswordActivityView {
        fun showToast(message : String)
        fun successChagePassword()
        fun showLoading()
        fun hideLoading()
    }

    interface ChagePasswordActivityPresenter {
        fun chagePassword(password : String, confirm_password : String, code_digit: String)
        fun destroy()
    }
}
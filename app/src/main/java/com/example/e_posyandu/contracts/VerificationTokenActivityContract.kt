package com.example.e_posyandu.contracts

import android.content.Context
import com.example.e_posyandu.models.User

interface VerificationTokenActivityContract {
    interface VerificationTokenActivityView {
        fun showToast(message : String)
        fun successVerificationToken(code_digit: String)
        fun showLoading()
        fun hideLoading()
    }

    interface VerificationTokenActivityPresenter {
        fun VerificationToken(code_digit : String)
        fun destroy()
    }
}
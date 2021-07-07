package com.example.e_posyandu.presenters

import android.content.Context
import com.example.e_posyandu.contracts.LoginActivityContract

class LoginActivityPresenter(v : LoginActivityContract.LoginView): LoginActivityContract.LoginPresenter {
    private var view : LoginActivityContract.LoginView? = v


    override fun login(email: String, password: String, context: Context) {

    }

    override fun destroy() {

    }
}
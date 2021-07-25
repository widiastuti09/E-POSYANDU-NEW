package com.example.e_posyandu.presenters

import android.content.Context
import com.example.e_posyandu.contracts.LoginActivityContract
import com.example.e_posyandu.contracts.ResetPasswordContract
import com.example.e_posyandu.models.User
import com.example.e_posyandu.responses.WrappedResponse
import com.example.e_posyandu.utilities.APIClient
import com.example.e_posyandu.utilities.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResetPasswordPresenter(v : ResetPasswordContract.ResetPasswordActivityView?) : ResetPasswordContract.ResetPasswordActivityPresenter {

    private var view: ResetPasswordContract.ResetPasswordActivityView? = v
    private var apiService = APIClient.APIService()

    override fun resetPassword(email: String) {
        val request = apiService.resetPassword(email)
        view?.showLoading()
        request.enqueue(object : Callback<WrappedResponse<String>> {
            override fun onResponse(
                call: Call<WrappedResponse<String>>,
                response: Response<WrappedResponse<String>>
            ) {
                println("RESPONSE " + response)
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null && body.status.equals(200)) {
                        view?.showToast(body.message)
                        view?.successResetPasword()
                    }
                } else {
                    view?.showToast("Terjadi kesalahan, silahkan coba lagi lain waktu")
                }
                view?.hideLoading()
            }

            override fun onFailure(call: Call<WrappedResponse<String>>, t: Throwable) {
                view?.showToast("Tidak bisa koneksi ke server")
                view?.hideLoading()
            }

        })
    }

    override fun destroy() {
        view = null
    }
}
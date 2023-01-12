package com.example.e_posyandu.presenters

import android.content.Context
import com.example.e_posyandu.contracts.LoginActivityContract
import com.example.e_posyandu.models.User
import com.example.e_posyandu.responses.WrappedResponse
import com.example.e_posyandu.utilities.APIClient
import com.example.e_posyandu.utilities.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivityPresenter(v : LoginActivityContract.LoginActivityView?) : LoginActivityContract.LoginActivityPresenter {

    private var view: LoginActivityContract.LoginActivityView? = v
    private var apiService = APIClient.APIService()

    override fun login(email: String, password: String, context: Context) {
        val request = apiService.loginMobile(email, password)
        view?.showLoading()
        request.enqueue(object : Callback<WrappedResponse<User>> {
            override fun onResponse(
                call: Call<WrappedResponse<User>>,
                response: Response<WrappedResponse<User>>
            ) {
                println("RESPONSE " + response)
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null && body.status.equals(200)) {
                        Constants.setToken(context, body.data.api_token!!)
                        Constants.setIdUser(context, body.data.id!!)
                        Constants.setName(context, body.data.name!!)
                        Constants.setEmail(context, body.data.email!!)
                        Constants.setRole(context, body.data.role!!)
                        view?.showToast("Selamat datang ${body.data.name}")
                        view?.successLogin(body.data)
                    }
                } else {
                    view?.showToast("Terjadi kesalahan, silahkan coba lagi lain waktu")
                }
                view?.hideLoading()
            }

            override fun onFailure(call: Call<WrappedResponse<User>>, t: Throwable) {
                view?.showToast("Tidak bisa koneksi ke server")
                view?.hideLoading()
            }

        })
    }

    override fun saveDeviceToken(token: String, device_token: String) {
        val request = apiService.saveDeviceToken("Bearer " + token , device_token)
        request.enqueue(object : Callback<WrappedResponse<String>>{
            override fun onResponse(
                call: Call<WrappedResponse<String>>,
                response: Response<WrappedResponse<String>>
            ) {
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null){
                        view?.showToast(body.message)
                    }else{
                        view?.showToast(body?.message!!)

                    }
                }else{
                    view?.showToast(response.message())
                    println("BODY "+ response.message())
                    println("RESPONSE "+ response)
                }
            }

            override fun onFailure(call: Call<WrappedResponse<String>>, t: Throwable) {
                view?.showToast("Tidak bisa koneksi ke server")
                println(t.message)
            }

        })
    }

    override fun destroy() {
        view = null
    }
}
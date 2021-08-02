package com.example.e_posyandu.presenters

import android.content.Context
import com.example.e_posyandu.contracts.EditProfileActivityContract
import com.example.e_posyandu.models.User
import com.example.e_posyandu.responses.WrappedResponse
import com.example.e_posyandu.utilities.APIClient
import com.example.e_posyandu.utilities.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfileActivityPresenter (v : EditProfileActivityContract.View?): EditProfileActivityContract.presenter{

    private var view : EditProfileActivityContract.View? = v
    private var apiService = APIClient.APIService()

    override fun changeDataProfile(token: String, id : String, name: String, email: String, password: String, context: Context) {
        val request = apiService.editProfile(token, id,  name, email, password)
        view?.showLoading()
        clearCurrentData(context)
        request.enqueue(object : Callback<WrappedResponse<User>>{
            override fun onResponse(call: Call<WrappedResponse<User>>, response: Response<WrappedResponse<User>>) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body != null && body.status.equals(200)){
                        view?.showToast("Profile Berhasil Berubah")
                        Constants.setName(context, body.data.name!!)
                        Constants.setEmail(context, body.data.email!!)
                    }
                }else{
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

    override fun changeDataProfileWithoutPassword(token: String, id: String, name: String, email: String, context: Context) {
        val request = apiService.editProfileWithoutPassword(token, id, name, email)
        clearCurrentData(context)
        request.enqueue(object : Callback<WrappedResponse<User>>{
            override fun onResponse(call: Call<WrappedResponse<User>>, response: Response<WrappedResponse<User>>) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body != null && body.status.equals(200)){
                        view?.showToast("Profile Berhasil Berubah")
                        Constants.setName(context, body.data.name!!)
                        Constants.setEmail(context, body.data.email!!)
                    }
                }else{
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

    private fun clearCurrentData(context: Context){
        Constants.clearName(context)
        Constants.clearEmail(context)
    }

    override fun destroy() {
        view = null
    }
}
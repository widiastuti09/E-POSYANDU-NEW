package com.example.e_posyandu.presenters

import com.example.e_posyandu.contracts.CatatanBumilActivityContract
import com.example.e_posyandu.models.IbuHamil
import com.example.e_posyandu.responses.WrappedListResponse
import com.example.e_posyandu.utilities.APIClient
import com.example.e_posyandu.utilities.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatatanBumilPresenter(v : CatatanBumilActivityContract.View?) : CatatanBumilActivityContract.presenter {

    private var view : CatatanBumilActivityContract.View? = v
    private var apiServices = APIClient.APIService()

    override fun getDataIbuHamil(token: String) {
        val request = apiServices.getIbuHamil("Bearer " + token)
        view?.showLoading()
        request.enqueue(object : Callback<WrappedListResponse<IbuHamil>>{
            override fun onResponse(
                call: Call<WrappedListResponse<IbuHamil>>,
                response: Response<WrappedListResponse<IbuHamil>>
            ) {
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null && body.status.equals(200)){
                        view?.attacthToRecycler(body?.data)
                    }
                }else{
                    view?.showToast("Terjadi kesalahan, silahkan coba lagi lain waktu")

                }
                view?.hideLoading()
            }

            override fun onFailure(call: Call<WrappedListResponse<IbuHamil>>, t: Throwable) {
                view?.showToast("Tidak bisa koneksi ke server")
                view?.hideLoading()
            }

        })
    }

    override fun destroy() {
        view = null
    }

}
package com.example.e_posyandu.presenters

import com.example.e_posyandu.contracts.CatatanAnakActivityContract
import com.example.e_posyandu.models.Anak
import com.example.e_posyandu.responses.WrappedListResponse
import com.example.e_posyandu.utilities.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatatanAnakPresenter(v : CatatanAnakActivityContract.View?) : CatatanAnakActivityContract.presenter {

    private var view : CatatanAnakActivityContract.View? = v
    private var apiServices = APIClient.APIService()

    override fun getDataAnak(token: String) {
        val request = apiServices.getBalita("Bearer "+ token)
        view?.showLoading()
        request.enqueue(object : Callback<WrappedListResponse<Anak>>{
            override fun onResponse(
                call: Call<WrappedListResponse<Anak>>,
                response: Response<WrappedListResponse<Anak>>
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

            override fun onFailure(call: Call<WrappedListResponse<Anak>>, t: Throwable) {
                view?.showToast("Tidak bisa koneksi ke server")
                view?.hideLoading()
            }

        })
    }

    override fun destroy() {
        view = null
    }
}
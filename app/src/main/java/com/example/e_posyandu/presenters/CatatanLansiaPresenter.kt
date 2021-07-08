package com.example.e_posyandu.presenters

import com.example.e_posyandu.contracts.CatatanLansiaFragmentContract
import com.example.e_posyandu.models.Lansia
import com.example.e_posyandu.responses.WrappedListResponse
import com.example.e_posyandu.utilities.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatatanLansiaPresenter(v: CatatanLansiaFragmentContract.View?) : CatatanLansiaFragmentContract.presenter {

    private var view : CatatanLansiaFragmentContract.View? = v
    private var apiServices = APIClient.APIService()

    override fun getDataLansia(token: String) {
        val request = apiServices.getLansia("Bearer " + token)
        view?.showLoading()
        request.enqueue(object : Callback<WrappedListResponse<Lansia>>{
            override fun onResponse(call: Call<WrappedListResponse<Lansia>>, response: Response<WrappedListResponse<Lansia>>) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body != null && body.status.equals(200)){
                        view?.attacthToRecycler(body?.data)
                    }
                }else{
                    view?.showToast("Terjadi Kesalahan, silahkan coba lagi lain waktu")
                }
                view?.hideLoading()
            }

            override fun onFailure(call: Call<WrappedListResponse<Lansia>>, t: Throwable) {
                view?.showToast("Tidak bisa koneksi ke server")
                view?.hideLoading()
            }
        })
    }

    override fun destroy() {
        view = null
    }


}
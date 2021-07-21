package com.example.e_posyandu.presenters

import com.example.e_posyandu.contracts.BumilResikoTinggiFragmentContract
import com.example.e_posyandu.models.IbuHamilResikoTinggi
import com.example.e_posyandu.responses.WrappedListResponse
import com.example.e_posyandu.utilities.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BumilResikoTinggiFragmentPresenter(v : BumilResikoTinggiFragmentContract.View?) : BumilResikoTinggiFragmentContract.presenter {

    private var view : BumilResikoTinggiFragmentContract.View? = v
    private var apiServices = APIClient.APIService()

    override fun getDataIbuHamilResikoTinggi(token: String, idBumil: String) {
        val request = apiServices.getBumilResti("Bearer "+ token, idBumil )
        view?.showLoading()
        request.enqueue(object : Callback<WrappedListResponse<IbuHamilResikoTinggi>>{
            override fun onResponse(call: Call<WrappedListResponse<IbuHamilResikoTinggi>>, response: Response<WrappedListResponse<IbuHamilResikoTinggi>>) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body != null && body.status.equals(200)){
                        if(body.data.size == 0){
                            view?.emptyData()
                        }else{
                            view?.attacthToRecycler(body?.data)
                        }
                    }
                }else{
                    view?.showToast("Terjadi kesalahan, silahkan coba lagi lain waktu")
                    println(response.message())
                }
                view?.hideLoading()
            }

            override fun onFailure(call: Call<WrappedListResponse<IbuHamilResikoTinggi>>, t: Throwable) {
                view?.showToast("Tidak dapat terkoneksi dengan server")
                view?.hideLoading()
            }
        })
    }

    override fun destroy() {
        view = null
    }
}
package com.example.e_posyandu.presenters

import com.example.e_posyandu.contracts.JadwalLansiaFragmentContract
import com.example.e_posyandu.models.JadwalLansia
import com.example.e_posyandu.responses.WrappedListResponse
import com.example.e_posyandu.utilities.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JadwalLansiaFragmentPresenter(v : JadwalLansiaFragmentContract.View?): JadwalLansiaFragmentContract.presenter {

    private var view : JadwalLansiaFragmentContract.View? = v
    private var apiService = APIClient.APIService()

    override fun getJadwalLansia(token: String) {
        val request = apiService.getJadwalLansia("Bearer "+ token)
        view?.showLoading()
        request.enqueue(object : Callback<WrappedListResponse<JadwalLansia>>{
            override fun onResponse(
                call: Call<WrappedListResponse<JadwalLansia>>,
                response: Response<WrappedListResponse<JadwalLansia>>
            ) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body != null && body.status.equals(200)){
                        view?.attacthToRecycler(body?.data)
                    }
                }else{
                    view?.showToast("Terjadi kesalahan, silahkan coba lagi lain waktu")
                }
                view?.hideLoading()
            }

            override fun onFailure(call: Call<WrappedListResponse<JadwalLansia>>, t: Throwable) {
                view?.showToast("Tidak bisa terkoneksi dengan server")
                view?.hideLoading()
            }
        })
    }

    override fun destroy() {
        view = null
    }
}
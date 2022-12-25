package com.example.e_posyandu.presenters

import com.example.e_posyandu.contracts.JadwalAnakFragmentContract
import com.example.e_posyandu.contracts.StatusImunisasiFragmentContract
import com.example.e_posyandu.models.Jadwal
import com.example.e_posyandu.models.StatusImunisasi
import com.example.e_posyandu.responses.WrappedListResponse
import com.example.e_posyandu.utilities.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatusImunisasiPresenter(v: StatusImunisasiFragmentContract.View?)  : StatusImunisasiFragmentContract.presenter {
    private var view : StatusImunisasiFragmentContract.View? = v
    private var apiServices = APIClient.APIService()

    override fun getStatusImunisasi(token: String, idAnak: String) {
        val request = apiServices.getStatusImunisasi("Bearer "+ token,idAnak)
        view?.showLoading()
        request.enqueue(object: Callback<WrappedListResponse<StatusImunisasi>>{
            override fun onResponse(
                call: Call<WrappedListResponse<StatusImunisasi>>,
                response: Response<WrappedListResponse<StatusImunisasi>>
            ) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body != null && body.status.equals(200)){
                        view?.attacthToRecycler(body.data)
                    }
                }else{
                    view?.showToast("Terjadi kesalahan, silahkan coba lagi lain waktu")
                }
                view?.hideLoading()
            }

            override fun onFailure(call: Call<WrappedListResponse<StatusImunisasi>>, t: Throwable) {
                view?.showToast("Tidak dapat terkoneksi dengan server")
                view?.hideLoading()
            }

        })
    }

    override fun destroy() {
        view = null
    }

}
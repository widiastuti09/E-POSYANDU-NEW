package com.example.e_posyandu.presenters

import com.example.e_posyandu.contracts.PemeriksaanBumilFragmentContract
import com.example.e_posyandu.models.PemeriksaanBumil
import com.example.e_posyandu.responses.WrappedListResponse
import com.example.e_posyandu.utilities.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PemeriksaanBumilFragmentPresenter(v : PemeriksaanBumilFragmentContract.View?): PemeriksaanBumilFragmentContract.presenter {
    private var view : PemeriksaanBumilFragmentContract.View? = v
    private var apiServices = APIClient.APIService()
    override fun getDataPemeriksaanBumil(token: String, idBumil: String) {
        val request = apiServices.getPemeriksaanBumil("Bearer "+ token, idBumil)
        view?.showLoading()
        request.enqueue(object : Callback<WrappedListResponse<PemeriksaanBumil>>{
            override fun onResponse(call: Call<WrappedListResponse<PemeriksaanBumil>>, response: Response<WrappedListResponse<PemeriksaanBumil>>) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body != null && body.status.equals(200)){
                        view?.attacthToView(body.data)
                    }
                }else{
                    view?.showToast("Terjadi kesalahan, silahkan coba lagi lain waktu")
                }
                view?.hideLoading()
            }

            override fun onFailure(call: Call<WrappedListResponse<PemeriksaanBumil>>, t: Throwable) {
                view?.showToast("Tidak bisa koneksi ke server")
                view?.hideLoading()
            }
        })
    }

    override fun destroy() {
        view = null
    }

}
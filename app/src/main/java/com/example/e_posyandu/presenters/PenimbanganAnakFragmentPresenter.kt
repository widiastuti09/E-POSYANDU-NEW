package com.example.e_posyandu.presenters

import com.example.e_posyandu.contracts.PenimbanganAnakFragmentContract
import com.example.e_posyandu.models.PenimbanganAnak
import com.example.e_posyandu.responses.WrappedListResponse
import com.example.e_posyandu.utilities.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PenimbanganAnakFragmentPresenter(v: PenimbanganAnakFragmentContract.View?): PenimbanganAnakFragmentContract.presenter {
    private var view : PenimbanganAnakFragmentContract.View? = v
    private var apiServices = APIClient.APIService()

    override fun getDataPenimbanganAnak(token: String, idAnak: String) {
        val request = apiServices.getPenimbanganAnak("Bearer "+ token, idAnak)
        view?.showLoading()
        request.enqueue(object : Callback<WrappedListResponse<PenimbanganAnak>> {
            override fun onResponse(call: Call<WrappedListResponse<PenimbanganAnak>>, response: Response<WrappedListResponse<PenimbanganAnak>>) {
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

            override fun onFailure(call: Call<WrappedListResponse<PenimbanganAnak>>, t: Throwable) {
                view?.showToast("Tidak bisa koneksi ke server")
                view?.hideLoading()
            }

        })
    }

    override fun destroy() {
        view = null
    }

}
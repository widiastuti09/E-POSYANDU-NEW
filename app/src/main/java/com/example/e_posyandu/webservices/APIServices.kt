package com.example.e_posyandu.webservices

import com.example.e_posyandu.models.Anak
import com.example.e_posyandu.models.IbuHamil
import com.example.e_posyandu.models.User
import com.example.e_posyandu.responses.WrappedListResponse
import com.example.e_posyandu.responses.WrappedResponse
import retrofit2.Call
import retrofit2.http.*

interface APIServices {
    @FormUrlEncoded
    @POST("login-mobile")
    fun loginMobile(
        @Field("email") email : String,
        @Field("password") password : String
    ) : Call<WrappedResponse<User>>

    @GET("balita")
    fun getBalita(
        @Header("Authorization") api_token : String,
    ) : Call<WrappedListResponse<Anak>>

    @GET("ibu-hamil")
    fun getIbuHamil(
        @Header("Authorization") api_token : String,
    ) : Call<WrappedListResponse<IbuHamil>>
}
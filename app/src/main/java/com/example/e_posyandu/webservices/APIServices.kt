package com.example.e_posyandu.webservices

import com.example.e_posyandu.models.*
import com.example.e_posyandu.responses.WrappedListResponse
import com.example.e_posyandu.responses.WrappedResponse
import retrofit2.Call
import retrofit2.http.*

interface APIServices {
    @FormUrlEncoded
    @POST("login-mobile")
    fun loginMobile(
        @Field("nik") email : String,
        @Field("password") password : String
    ) : Call<WrappedResponse<User>>

    @FormUrlEncoded
    @POST("save-token")
    fun saveDeviceToken(
        @Header("Authorization") token : String,
        @Field("device_token") device_token : String
    ) : Call<WrappedResponse<String>>

    @FormUrlEncoded
    @POST("reset-password")
    fun resetPassword(
        @Field("email") email : String
    ) : Call<WrappedResponse<String>>

    @FormUrlEncoded
    @POST("verification-code")
    fun verificationToken(
        @Field("code_digit") code_digit : String
    ) : Call<WrappedResponse<String>>

    @FormUrlEncoded
    @POST("ganti-password")
    fun chagePassword(
        @Field("password") password : String,
        @Field("konfirmasi_password") konfirmasi_password: String,
        @Field("code_digit") code_digit : String
    ) : Call<WrappedResponse<String>>

    @GET("balita")
    fun getBalita(
        @Header("Authorization") api_token : String
    ) : Call<WrappedListResponse<Anak>>

    @GET("jadwal-balita")
    fun getJadwalBalita(
        @Header("Authorization") api_token : String
    ): Call<WrappedListResponse<Jadwal>>

    @GET("ibu-hamil")
    fun getIbuHamil(
        @Header("Authorization") api_token : String
    ) : Call<WrappedListResponse<IbuHamil>>

    @GET("jadwal-bumil")
    fun getJadwalBumil(
        @Header("Authorization") api_token : String
    ): Call<WrappedListResponse<Jadwal>>

    @GET("Bumilresti/{id}")
    fun getBumilResti(
        @Header("Authorization") api_token : String,
        @Path("id") id: String
    ): Call<WrappedListResponse<IbuHamilResikoTinggi>>

    @GET("lansia")
    fun getLansia(
        @Header("Authorization") api_token: String
    ):Call<WrappedListResponse<Lansia>>

    @GET("jadwal-lansia")
    fun getJadwalLansia(
        @Header("Authorization") api_token : String
    ): Call<WrappedListResponse<Jadwal>>

    @GET("penimbangan-balita/{id}")
    fun getPenimbanganAnak(
        @Header("Authorization") api_token: String,
        @Path("id")id : String
    ): Call<WrappedListResponse<PenimbanganAnak>>

    @GET("pemeriksaan-bumil/{id}")
    fun getPemeriksaanBumil(
        @Header("Authorization") api_token: String,
        @Path("id")id : String
    ): Call<WrappedListResponse<PemeriksaanBumil>>

    @GET("pemeriksaan-lansia/{id}")
    fun getPemeriksaanLansia(
        @Header("Authorization") api_token: String,
        @Path("id")id : String
    ):Call<WrappedListResponse<PemeriksaanLansia>>

    @FormUrlEncoded
    @PUT("edit-profile/{id}")
    fun editProfile(
        @Header("Authorization") api_token: String,
        @Path("id")id : String,
        @Field("name")  name : String,
        @Field("email")  email: String,
        @Field("password")  password : String
    ): Call<WrappedResponse<User>>

    @FormUrlEncoded
    @PUT("edit-profile/{id}")
    fun editProfileWithoutPassword(
            @Header("Authorization") api_token: String,
            @Path("id")id : String,
            @Field("name")  name : String,
            @Field("email")  email: String,
    ): Call<WrappedResponse<User>>

    @GET("status-imunisasi/{id}")
    fun getStatusImunisasi(
        @Header("Authorization") api_token: String,
        @Path("id") id: String
    ):Call<WrappedListResponse<StatusImunisasi>>
}
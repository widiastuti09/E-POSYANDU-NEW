package com.example.e_posyandu.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Lansia(
    @SerializedName("id") var id : String? = null,
    @SerializedName("tanggal_lahir") var tanggalLahir : String? = null,
    @SerializedName("nama") var nama : String? = null,
    @SerializedName("jenis_kelamin") var jenisKelamin : String? = null,
    @SerializedName("rt") var rt : String? = null,
    @SerializedName("rw") var rw : String? = null,
    @SerializedName("alamat") var alamat : String? = null,
    @SerializedName("user_id") var userId : String? = null
):Parcelable
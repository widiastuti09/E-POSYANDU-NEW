package com.example.e_posyandu.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Jadwal (
    @SerializedName("id") var id : String? = null,
    @SerializedName("tanggal") var tanggal : String? = null,
    @SerializedName("waktu") var waktu : String? = null,
    @SerializedName("keterangan") var keterangan : String? = null,
    @SerializedName("status") var status : String? = null
) : Parcelable
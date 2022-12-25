package com.example.e_posyandu.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StatusImunisasi(
    @SerializedName("jenis") var jenis: String?,
    @SerializedName("status") var status: String?,
    @SerializedName("tanggal") var tanggal: String?
): Parcelable

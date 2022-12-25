package com.example.e_posyandu.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PenimbanganAnak (
        @SerializedName("id") var id : String? = null,
        @SerializedName("namabalita_id") var namabalita_id : String? = null,
        @SerializedName("tanggal") var tanggal : String? = null,
        @SerializedName("jenis_imunisasi") var jenis_imunisasi : String? = null,
        @SerializedName("beratbadan") var beratbadan : String? = null,
        @SerializedName("imp") var imp : String? = null,
        @SerializedName("kia") var kia : String? = null,
        @SerializedName("vitamin") var vitamin : String? = null,
        @SerializedName("penyakit") var penyakit : String? = null,
        @SerializedName("umur") var umur : String? = null

): Parcelable
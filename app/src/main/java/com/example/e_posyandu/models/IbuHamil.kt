package com.example.e_posyandu.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IbuHamil (
    @SerializedName("id") var id : String? = null,
    @SerializedName("nama") var nama : String? = null,
    @SerializedName("tgllahir") var tgllahir : String? = null,
    @SerializedName("namasuami") var namasuami : String? = null,
    @SerializedName("goldarah") var goldarah : String? = null,
    @SerializedName("usia") var usia : String? = null,
    @SerializedName("rt") var rt : String? = null,
    @SerializedName("rw") var rw : String? = null,
    @SerializedName("telp") var telp : String? = null,
    @SerializedName("tglregister") var tglregister : String? = null,
    @SerializedName("user_id") var user_id : String? = null,
    @SerializedName("created_at") var created_at : String? = null,
    @SerializedName("updated_at") var updated_at : String? = null,
) : Parcelable
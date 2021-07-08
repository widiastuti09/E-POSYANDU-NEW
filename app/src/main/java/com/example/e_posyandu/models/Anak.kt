package com.example.e_posyandu.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Anak (
    @SerializedName("id") var id : String? = null,
    @SerializedName("namabalita") var namabalita : String? = null,
    @SerializedName("tempatlahir") var tempatlahir : String? = null,
    @SerializedName("tanggallahir") var tanggallahir : String? = null,
    @SerializedName("jeniskelamin") var jeniskelamin : String? = null,
    @SerializedName("namaayah") var namaayah : String? = null,
    @SerializedName("namaibu") var namaibu : String? = null,
    @SerializedName("rt") var rt : String? = null,
    @SerializedName("rw") var rw : String? = null,
    @SerializedName("usia") var usia : String? = null,
    @SerializedName("bblahir") var bblahir : String? = null,
    @SerializedName("pblahir") var pblahir : String? = null,
    @SerializedName("nokk") var nokk : String? = null,
    @SerializedName("nikbalita") var nikbalita : String? = null,
    @SerializedName("telp") var telp : String? = null,
    @SerializedName("user_id") var user_id : String? = null,
    @SerializedName("created_at") var created_at : String? = null,
    @SerializedName("updated_at") var updated_at : String? = null,
    @SerializedName("id_ibu") var id_ibu : String? = null,
        ) : Parcelable
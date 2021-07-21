package com.example.e_posyandu.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IbuHamilResikoTinggi (
        @SerializedName("id") var id : String? = null,
        @SerializedName("umur_hamil") var umur_hamil : String? = null,
        @SerializedName("gpa") var gpa : String? = null,
        @SerializedName("asuransi") var asuransi : String? = null,
        @SerializedName("resiko_tinggi") var resiko_tinggi : String? = null,
        @SerializedName("hpl") var hpl : String? = null,
        @SerializedName("wali_bumil") var wali_bumil : String? = null,
        @SerializedName("id_ibu") var id_ibu : String? = null,
        @SerializedName("created_at") var created_at : String? = null,
        @SerializedName("updated_at") var updated_at : String? = null,
): Parcelable

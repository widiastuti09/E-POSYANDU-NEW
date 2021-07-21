package com.example.e_posyandu.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PemeriksaanBumil(
        @SerializedName("id") var id : String? = null,
        @SerializedName("hemoglobin_atas") var hemoglobin_atas : String? = null,
        @SerializedName("hemoglobin_bawah") var hemoglobin_bawah : String? = null,
        @SerializedName("hpht") var hpht : String? = null,
        @SerializedName("htp") var htp : String? = null,
        @SerializedName("tinggibadan") var tinggibadan : String? = null,
        @SerializedName("beratbadan") var beratbadan : String? = null,
        @SerializedName("hamilke") var hamilke : String? = null,
        @SerializedName("persalinanke") var persalinanke : String? = null,
        @SerializedName("keguguranke") var keguguranke : String? = null,
        @SerializedName("id_ibu") var id_ibu : String? = null,
        @SerializedName("created_at") var created_at : String? = null,
        @SerializedName("updated_at") var updated_at : String? = null,
):Parcelable
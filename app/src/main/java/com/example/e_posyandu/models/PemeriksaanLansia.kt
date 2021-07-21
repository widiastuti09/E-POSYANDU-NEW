package com.example.e_posyandu.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PemeriksaanLansia (
        @SerializedName("id") var id : String? = null,
        @SerializedName("namalansia_id") var namalansia_id : String? = null,
        @SerializedName("tanggal_periksa") var tanggal_periksa : String? = null,
        @SerializedName("berat_badan") var berat_badan : String? = null,
        @SerializedName("tinggi_badan") var tinggi_badan : String? = null,
        @SerializedName("lingkar_pinggang") var lingkar_pinggang : String? = null,
        @SerializedName("tekanan_darah") var tekanan_darah : String? = null,
        @SerializedName("glukosa_darah") var glukosa_darah : String? = null,
        @SerializedName("lemak_tubuh") var lemak_tubuh : String? = null,
        @SerializedName("imt") var imt : String? = null,
        @SerializedName("lemak_perut") var lemak_perut : String? = null,
        @SerializedName("kolestrol") var kolestrol : String? = null,
        @SerializedName("asam_urat") var asam_urat : String? = null,
        @SerializedName("makan_berlemak") var makan_berlemak : String? = null,
        @SerializedName("makan_manis") var makan_manis : String? = null,
        @SerializedName("zat_adiktif") var zat_adiktif : String? = null,
        @SerializedName("jelantah") var jelantah : String? = null,
        @SerializedName("merokok") var merokok : String? = null,
        @SerializedName("olahraga") var olahraga : String? = null,
        @SerializedName("keterangan") var keterangan : String? = null,
        @SerializedName("penyakit") var penyakit : String? = null,
):Parcelable
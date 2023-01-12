package com.example.e_posyandu.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @SerializedName("id") var id: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("email") var email: String?,
    @SerializedName("level") var level: String?,
    @SerializedName("api_token") var api_token: String?,
    @SerializedName("created_at") var created_at: String?,
    @SerializedName("updated_at") var updated_at: String?,
    @SerializedName("role") var role: String?
) : Parcelable {
    constructor() : this(null, null, null, null, null, null, null, null)
}
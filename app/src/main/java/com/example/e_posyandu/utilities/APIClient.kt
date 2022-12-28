package com.example.e_posyandu.utilities

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.e_posyandu.webservices.APIServices
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIClient {
    companion object {
        private var retrofit: Retrofit? = null
        private var okHttpClient = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build()

        fun APIService(): APIServices = getClient().create(APIServices::class.java)

        private fun getClient(): Retrofit {
            return if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(Constants.API_ENDPOINT).client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                retrofit!!
            } else {
                retrofit!!
            }
        }
    }
}

class Constants {
    companion object {
        const val API_ENDPOINT = "https://posyandu.khiostore.com/api/"

        fun getToken(context: Context): String {
            val pref = context.getSharedPreferences("TOKEN", MODE_PRIVATE)
            val token = pref?.getString("TOKEN", "UNDEFINED")
            return token!!
        }

        fun setToken(context: Context, token: String) {
            val pref = context.getSharedPreferences("TOKEN", MODE_PRIVATE)
            pref.edit().apply {
                putString("TOKEN", token)
                apply()
            }
        }

        fun clearToken(context: Context) {
            val pref = context.getSharedPreferences("TOKEN", MODE_PRIVATE)
            pref.edit().clear().apply()
        }

        fun getDeviceToken(context: Context): String {
            val pref = context.getSharedPreferences("DEVICE_TOKEN", MODE_PRIVATE)
            val token = pref?.getString("DEVICE_TOKEN", "UNDEFINED")
            return token!!
        }

        fun setDeviceToken(context: Context, token: String) {
            val pref = context.getSharedPreferences("DEVICE_TOKEN", MODE_PRIVATE)
            pref.edit().apply {
                putString("DEVICE_TOKEN", token)
                apply()
            }
        }

        fun setName(context: Context, name: String) {
            val pref = context.getSharedPreferences("NAME", MODE_PRIVATE)
            pref.edit().putString("NAME", name).apply()
        }

        fun getName(context: Context): String {
            val pref = context.getSharedPreferences("NAME", MODE_PRIVATE)
            val name = pref.getString("NAME", "UNDEFINED")
            return name!!
        }

        fun clearName(context: Context) {
            val pref = context.getSharedPreferences("NAME", MODE_PRIVATE)
            pref.edit().clear().apply()
        }

        fun setEmail(context: Context, email: String) {
            val pref = context.getSharedPreferences("EMAIL", MODE_PRIVATE)
            pref.edit().putString("EMAIL", email).apply()
        }

        fun getEmail(context: Context): String {
            val pref = context.getSharedPreferences("EMAIL", MODE_PRIVATE)
            val email = pref.getString("EMAIL", "UNDEFINED")
            return email!!
        }

        fun clearEmail(context: Context) {
            val pref = context.getSharedPreferences("EMAIL", MODE_PRIVATE)
            pref.edit().clear().apply()
        }

        fun setIdUser(context: Context, id: String) {
            val pref = context.getSharedPreferences("ID", MODE_PRIVATE)
            pref.edit().putString("ID", id).apply()
        }

        fun getIdUser(context: Context): String {
            val pref = context.getSharedPreferences("ID", MODE_PRIVATE)
            val idUser = pref.getString("ID", "UNDEFINED")
            return idUser!!
        }

        fun clearIdUser(context: Context) {
            val pref = context.getSharedPreferences("ID", MODE_PRIVATE)
            pref.edit().clear().apply()
        }

        fun setRole(context: Context, name: String) {
            val pref = context.getSharedPreferences("ROLE", MODE_PRIVATE)
            pref.edit().putString("ROLE", name).apply()
        }

        fun getRole(context: Context): String {
            val pref = context.getSharedPreferences("ROLE", MODE_PRIVATE)
            val name = pref.getString("ROLE", "UNDEFINED")
            return name!!
        }

        fun clearRole(context: Context) {
            val pref = context.getSharedPreferences("ROLE", MODE_PRIVATE)
            pref.edit().clear().apply()
        }

    }
}

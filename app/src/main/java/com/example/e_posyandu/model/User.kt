package com.example.e_posyandu.model

data class User(
        var id: Int,
        var name: String,
        var username: String,
        var email: String,
        var password : String,
        var token : String
)
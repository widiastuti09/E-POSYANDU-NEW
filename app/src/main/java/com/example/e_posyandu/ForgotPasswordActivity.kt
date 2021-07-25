package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_posyandu.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding : ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        goBack()
    }

    private fun goBack(){
        binding.tvBackToLogin.setOnClickListener {
            finish()
        }
    }
}
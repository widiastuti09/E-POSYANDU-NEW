package com.example.e_posyandu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.e_posyandu.contracts.ResetPasswordContract
import com.example.e_posyandu.databinding.ActivityForgotPasswordBinding
import com.example.e_posyandu.presenters.ResetPasswordPresenter

class ForgotPasswordActivity : AppCompatActivity(), ResetPasswordContract.ResetPasswordActivityView {
    private lateinit var binding : ActivityForgotPasswordBinding
    private var presenter : ResetPasswordContract.ResetPasswordActivityPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        presenter = ResetPasswordPresenter(this)
        doSubmit()
        goBack()
    }

    private fun goBack(){
        binding.tvBackToLogin.setOnClickListener {
            finish()
        }
    }

    private fun doSubmit(){
        binding.btnSubmit.setOnClickListener {
            val email = binding.etEmail.text.toString()
            presenter?.resetPassword(email)
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun successResetPasword() {
        startActivity(Intent(this, VerificationActivity::class.java))
    }

    override fun showLoading() {
        binding.loadingLogin.isIndeterminate = true
    }

    override fun hideLoading() {
        binding.loadingLogin.apply {
            isIndeterminate = false
            progress = 0
            visibility = View.GONE
        }
    }
}
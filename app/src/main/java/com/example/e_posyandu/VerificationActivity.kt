package com.example.e_posyandu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.e_posyandu.contracts.ResetPasswordContract
import com.example.e_posyandu.contracts.VerificationTokenActivityContract
import com.example.e_posyandu.databinding.ActivityVerificationBinding
import com.example.e_posyandu.presenters.ResetPasswordPresenter
import com.example.e_posyandu.presenters.VerificationTokenActivityPresenter

class VerificationActivity : AppCompatActivity(), VerificationTokenActivityContract.VerificationTokenActivityView {
    private lateinit var binding : ActivityVerificationBinding
    private var presenter : VerificationTokenActivityContract.VerificationTokenActivityPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        presenter = VerificationTokenActivityPresenter(this)
        setContentView(binding.root)
        doSubmit()
        goBack()
    }

    private fun goBack(){
        binding.tvBackToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }

    private fun doSubmit(){
        binding.btnSubmit.setOnClickListener {
            val code_digit = binding.etEmail.text.toString()
            presenter?.VerificationToken(code_digit)
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun successVerificationToken(code_digit: String) {
        startActivity(Intent(this, ChagePasswordActivity::class.java).putExtra("codeDigit", code_digit))
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
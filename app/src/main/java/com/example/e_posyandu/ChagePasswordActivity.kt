package com.example.e_posyandu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.e_posyandu.contracts.ChagePasswordActivityContract
import com.example.e_posyandu.databinding.ActivityChagePasswordBinding
import com.example.e_posyandu.presenters.ChagePasswordActivityPresenter

class ChagePasswordActivity : AppCompatActivity(), ChagePasswordActivityContract.ChagePasswordActivityView {
    private lateinit var binding: ActivityChagePasswordBinding
    private var presenter : ChagePasswordActivityContract.ChagePasswordActivityPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChagePasswordBinding.inflate(layoutInflater)
        presenter = ChagePasswordActivityPresenter(this)
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
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etPasswordConfirm.text.toString()
            val code_digit = intent.getStringExtra("codeDigit").toString()
            if (password == confirmPassword){
                presenter?.chagePassword(password, confirmPassword, code_digit)
            }
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun successChagePassword() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun showLoading() {
//        binding.loadingLogin.isIndeterminate = true
    }

    override fun hideLoading() {
//        binding.loadingLogin.apply {
//            isIndeterminate = false
//            progress = 0
//            visibility = View.GONE
//        }
    }
}
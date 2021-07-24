package com.example.e_posyandu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.e_posyandu.contracts.LoginActivityContract
import com.example.e_posyandu.databinding.ActivityLoginBinding
import com.example.e_posyandu.models.User
import com.example.e_posyandu.presenters.LoginActivityPresenter
import com.example.e_posyandu.utilities.Constants

class LoginActivity : AppCompatActivity(), LoginActivityContract.LoginActivityView{

    private var presenter : LoginActivityContract.LoginActivityPresenter? = null
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = LoginActivityPresenter(this)
        supportActionBar?.hide()
        doLogin()
        hideLoading()
        forgotPassword()
    }

    private fun forgotPassword(){
        binding.tvForgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }

    private fun doLogin(){
        binding.btnLogin.setOnClickListener {
            val email = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if(email.isNotEmpty() && password.isNotEmpty()){
                presenter?.login(email, password, this@LoginActivity)
            }else{
                showToast("Tolong isi semua form")
            }
        }
    }

    override fun showToast(message: String) = Toast.makeText(this@LoginActivity, message, Toast.LENGTH_LONG).show()

    override fun successLogin(user: User) {
        val deviceToken = Constants.getDeviceToken(this@LoginActivity)
        println("DEVICE TOKEN "+ deviceToken);
        if(deviceToken != null || deviceToken != "UNDEFINED"){
            presenter?.saveDeviceToken(user?.api_token!!, deviceToken)
            startActivity(Intent(this@LoginActivity, MainActivity::class.java)).also{
                finish()
            }
        }
    }


    override fun showLoading() {
        binding.btnLogin.isEnabled = false
        binding.loadingLogin.apply {
            isIndeterminate = true
        }
    }

    override fun hideLoading() {
        binding.btnLogin.isEnabled = true
        binding.loadingLogin.apply {
            isIndeterminate = false
            progress = 0
            visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroy()
    }

    override fun onResume() {
        super.onResume()
        val token = Constants.getToken(this@LoginActivity)
        if(!token.equals("UNDEFINED")){
            startActivity(Intent(this@LoginActivity, MainActivity::class.java).also { finish() })
        }
    }

}
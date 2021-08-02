package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.e_posyandu.contracts.EditProfileActivityContract
import com.example.e_posyandu.databinding.ActivityEditProfileBinding
import com.example.e_posyandu.presenters.EditProfileActivityPresenter
import com.example.e_posyandu.utilities.Constants

class EditProfileActivity : AppCompatActivity(), EditProfileActivityContract.View {
    private lateinit var binding : ActivityEditProfileBinding
    private  var presenter : EditProfileActivityContract.presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = EditProfileActivityPresenter(this)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.title = "Edit Profile"
        hideLoading()
        changeProfileData()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun changeProfileData(){
        val token = Constants.getToken(this)
        val currentName = Constants.getName(this)
        val currentEmail = Constants.getEmail(this)
        val idUser = Constants.getIdUser(this)
        binding.etName.setText(currentName)
        binding.etEmail.setText(currentEmail)

        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmPass = binding.etConfirmPassword.text.toString().trim()

            if(name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()&& confirmPass.isNotEmpty()){
                if (password != confirmPass){
                    showToast("Password harus sama")
                }else{
                    presenter?.changeDataProfile(token, idUser, name, email, password, this)
                    clearForm()
                }
            }else if(password.isEmpty() && confirmPass.isEmpty()){
                    presenter?.changeDataProfileWithoutPassword(token, idUser, name, email, this)
                    clearForm()
            }else{
                showToast("Tolong isi semua form")
            }
        }
    }

    private fun clearForm(){
        binding.etName.setText("")
        binding.etEmail.setText("")
        binding.etPassword.setText("")
        binding.etConfirmPassword.setText("")
    }


    override fun showLoading() {
        binding.loading.apply{
            isIndeterminate = true
        }
    }

    override fun hideLoading() {
        binding.loading.apply{
            isIndeterminate = false
            progress = 0
            visibility = View.GONE
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroy()
    }

}
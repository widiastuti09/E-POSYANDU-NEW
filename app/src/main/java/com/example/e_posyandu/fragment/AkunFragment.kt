package com.example.e_posyandu.fragment

import android.os.Bundle
import android.provider.SyncStateContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_posyandu.R
import com.example.e_posyandu.databinding.FragmentAkunBinding
import com.example.e_posyandu.utilities.Constants


class AkunFragment : Fragment() {

    private var _binding : FragmentAkunBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentAkunBinding.inflate(inflater, container, false)
        showContentAkun()
        return binding.root
    }

    private fun showContentAkun(){
        val name = Constants.getName(requireActivity())
        val email = Constants.getEmail(requireActivity())
        println(" AKUN  $name + $ $email")
        binding.tvName.text = name
        binding.tvEmail.text = email
    }
}
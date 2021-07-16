package com.example.e_posyandu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_posyandu.R
import com.example.e_posyandu.databinding.FragmentBumilResikoTinggiBinding


class BumilResikoTinggiFragment : Fragment() {

    private var _binding : FragmentBumilResikoTinggiBinding? = null
    private val binding get() = _binding!!

    companion object{
        private var idBumil : String? = null
        fun getIdbumil (idBumil : String) : BumilResikoTinggiFragment{
            val fragment = BumilResikoTinggiFragment()
            this.idBumil = idBumil
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentBumilResikoTinggiBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


}
package com.example.e_posyandu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_posyandu.R
import com.example.e_posyandu.databinding.FragmentJadwalImunisasiAnakBinding


class JadwalImunisasiAnakFragment : Fragment() {

    private var _binding : FragmentJadwalImunisasiAnakBinding? = null
    private val  binding get() = _binding!!

    companion object{
        private var idAnak: String? = null
        fun getUserIdAnak(idAnak: String): JadwalImunisasiAnakFragment {
            val fragment = JadwalImunisasiAnakFragment()
            this.idAnak = idAnak
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJadwalImunisasiAnakBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }




}
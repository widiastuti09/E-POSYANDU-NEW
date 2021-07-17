package com.example.e_posyandu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_posyandu.R
import com.example.e_posyandu.databinding.FragmentTentangAplikasiBinding


class TentangAplikasiFragment : Fragment() {

    private var _binding : FragmentTentangAplikasiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentTentangAplikasiBinding.inflate(inflater, container, false)
        return binding.root
    }


}
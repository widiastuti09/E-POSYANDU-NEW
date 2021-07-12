package com.example.e_posyandu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_posyandu.R
import com.example.e_posyandu.databinding.FragmentPenimbanganBumilBinding


class PenimbanganBumilFragment : Fragment() {

    private var _binding : FragmentPenimbanganBumilBinding? = null
    private val binding get() = _binding!!

    companion object{
        private var idBumil : String? = null
        fun getIdbumil(idBumil : String) : PenimbanganBumilFragment{
            val fragment = PenimbanganBumilFragment()
            this.idBumil = idBumil
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_penimbangan_bumil, container, false)
    }

   
}
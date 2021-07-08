package com.example.e_posyandu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_posyandu.R


class JadwalImunisasiAnakFragment : Fragment() {

    companion object{
        const val ARG_PARAM = "idAnak"
        fun getIdAnak(id : String) : JadwalImunisasiAnakFragment {
            val jadwalFragment = JadwalImunisasiAnakFragment()
            val bundle = Bundle().apply{
                putString(ARG_PARAM, id)
            }
            jadwalFragment.arguments = bundle
            return jadwalFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val idAnak = arguments?.getString(ARG_PARAM)
        println("id From Activity $idAnak")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal_imunisasi_anak, container, false)

    }




}
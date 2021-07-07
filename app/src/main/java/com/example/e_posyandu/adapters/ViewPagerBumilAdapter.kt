package com.example.e_posyandu.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.e_posyandu.fragment.JadwalImunisasiAnakFragment
import com.example.e_posyandu.fragment.KesehatanBumilFragment
import com.example.e_posyandu.fragment.PenimbanganAnakFragment
import com.example.e_posyandu.fragment.PenimbanganBumilFragment

@Suppress("DEPRECATION")
class ViewPagerBumilAdapter(supportFragmentManager: FragmentManager): FragmentPagerAdapter
    (supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 ->{
                PenimbanganBumilFragment()
            }
            else ->{
                KesehatanBumilFragment()
            }

        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Penimbangan"
            else -> "Kesehatan"

        }
    }
}
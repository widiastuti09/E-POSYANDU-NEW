package com.example.e_posyandu.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.e_posyandu.fragment.ImunisasiAnakFragment
import com.example.e_posyandu.fragment.JadwalImunisasiAnakFragment
import com.example.e_posyandu.fragment.PenimbanganAnakFragment

@Suppress("DEPRECATION")
class ViewPagerAnakAdapter(supportFragmentManager: FragmentManager): FragmentPagerAdapter
    (supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 ->{
                JadwalImunisasiAnakFragment()
            }
            else ->{
                PenimbanganAnakFragment()
            }

        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Jadwal"
            else -> "Penimbangan"

        }
    }
}
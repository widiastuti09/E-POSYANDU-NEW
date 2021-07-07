package com.example.e_posyandu.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.e_posyandu.fragment.KesehatanBumilFragment
import com.example.e_posyandu.fragment.KesehatanLansiaFragment


class ViewPagerLansiaAdapter (supportFragmentManager: FragmentManager): FragmentPagerAdapter
    (supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 ->{
                KesehatanLansiaFragment()
            }
            else -> return KesehatanLansiaFragment()

        }
    }

    override fun getCount(): Int {
        return 1
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Kesehatan Lansia"
            else -> "0"

        }
    }
}
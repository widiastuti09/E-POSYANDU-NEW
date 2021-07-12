package com.example.e_posyandu.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.e_posyandu.fragment.JadwalLansiaFragment
import com.example.e_posyandu.fragment.PemeriksaanLansiaFragment
import java.util.*


@Suppress("DEPRECATION")
class ViewPagerLansiaAdapter (supportFragmentManager: FragmentManager): FragmentPagerAdapter
    (supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    private var idLansia : String? = null
    private val mfragmentList : MutableList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 ->{
                JadwalLansiaFragment()
            }
            else -> PemeriksaanLansiaFragment()
        }
    }

    override fun getCount(): Int  = mfragmentList.size

    fun addFragment(fragment: Fragment?, idLansia : String?){
        mfragmentList.add(fragment!!)
        this.idLansia = idLansia
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Jadwal"
            else -> "Pemeriksaan Lansia"

        }
    }
}
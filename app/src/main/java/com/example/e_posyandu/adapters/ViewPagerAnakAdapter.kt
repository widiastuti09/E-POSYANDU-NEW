package com.example.e_posyandu.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.e_posyandu.fragment.GrafikPenimbanganFragment
import com.example.e_posyandu.fragment.JadwalAnakFragment
import com.example.e_posyandu.fragment.PenimbanganAnakFragment
import com.example.e_posyandu.fragment.StatusImunisasiFragment
import java.util.*

@Suppress("DEPRECATION")
class ViewPagerAnakAdapter(supportFragmentManager: FragmentManager): FragmentPagerAdapter
(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    private var idAnak: String? = null
    private val mFragmentList: MutableList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> {
                JadwalAnakFragment()
            }
            1 ->{
                PenimbanganAnakFragment()
            }
            2 -> {
                StatusImunisasiFragment()
            }
            else -> {
                GrafikPenimbanganFragment()
            }
        }
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment?, idAnak: String?) {
        mFragmentList.add(fragment!!)
        this.idAnak = idAnak
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Jadwal"
            1 -> "Penimbangan"
            2 -> "Imunisasi"
            else -> "Grafik Penimbangan"

        }
    }
}
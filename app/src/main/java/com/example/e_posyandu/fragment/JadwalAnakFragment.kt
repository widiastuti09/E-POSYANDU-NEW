package com.example.e_posyandu.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_posyandu.DetailJadwalAnakActivity
import com.example.e_posyandu.adapters.JadwalAnakAdapter
import com.example.e_posyandu.adapters.JadwalAnakListener
import com.example.e_posyandu.contracts.JadwalAnakFragmentContract
import com.example.e_posyandu.databinding.FragmentJadwalAnakBinding
import com.example.e_posyandu.models.Jadwal
import com.example.e_posyandu.models.JadwalAnak
import com.example.e_posyandu.presenters.JadwalAnakFragmentPresenter
import com.example.e_posyandu.utilities.Constants


class JadwalAnakFragment : Fragment(), JadwalAnakFragmentContract.View {

    private var _binding : FragmentJadwalAnakBinding? = null
    private val  binding get() = _binding!!
    private var presenter : JadwalAnakFragmentContract.presenter? = null
    private lateinit var jadwalAnakAdapter : JadwalAnakAdapter

    companion object{
        private var idAnak: String? = null
        fun getUserIdAnak(idAnak: String): JadwalAnakFragment {
            val fragment = JadwalAnakFragment()
            this.idAnak = idAnak
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJadwalAnakBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter = JadwalAnakFragmentPresenter(this)
        return view
    }

    private fun getTokenAndId(){
        val token = Constants.getToken(requireActivity())
        presenter?.getJadwalAnak(token)
    }

    override fun attacthToRecycler(jadwalAnak: List<Jadwal>) {
        Log.d("Jadwal Anak", " $jadwalAnak")
        jadwalAnakAdapter = JadwalAnakAdapter(jadwalAnak, object : JadwalAnakListener{
            override fun onDetailJadwalAnak(jadwalAnak: Jadwal) {
                startActivity(Intent(activity, DetailJadwalAnakActivity::class.java).apply{
                    putExtra("jadwal", jadwalAnak)
                })
            }
        })
        binding.rvJadwalAnak.apply{
            adapter = jadwalAnakAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun showLoading() {
        binding.loading.apply{
            isIndeterminate = true
        }
    }

    override fun hideLoading() {
        binding.loading.apply{
            isIndeterminate = false
            progress = 0
            visibility = View.GONE
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG). show()
    }

    override fun onResume() {
        super.onResume()
        getTokenAndId()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroy()
    }

}
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
import com.example.e_posyandu.DetailJadwalLansiaActivity
import com.example.e_posyandu.R
import com.example.e_posyandu.adapters.JadwalLansiaAdapter
import com.example.e_posyandu.adapters.JadwalLansiaListener
import com.example.e_posyandu.contracts.JadwalLansiaFragmentContract
import com.example.e_posyandu.databinding.FragmentJadwalLansiaBinding
import com.example.e_posyandu.models.Jadwal
import com.example.e_posyandu.models.JadwalLansia
import com.example.e_posyandu.presenters.JadwalLansiaFragmentPresenter
import com.example.e_posyandu.utilities.Constants


class JadwalLansiaFragment : Fragment(), JadwalLansiaFragmentContract.View {

    private var _binding : FragmentJadwalLansiaBinding? = null
    private val binding get() = _binding!!
    private var presenter : JadwalLansiaFragmentContract.presenter? = null
    private lateinit var jadwalLansiaAdapter : JadwalLansiaAdapter

    companion object{
        private var idLansia : String? = null
        fun getIdLansia(idLansia : String) : JadwalLansiaFragment{
            val fragment = JadwalLansiaFragment()
            this.idLansia = idLansia
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentJadwalLansiaBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter = JadwalLansiaFragmentPresenter(this)
        return view
    }

    private fun getTokenAndId() {
        val token = Constants.getToken(requireActivity())
        presenter?.getJadwalLansia(token)
    }

    override fun attacthToRecycler(jadwalLansia: List<Jadwal>) {
        Log.d("Jadwal Lansia", " $jadwalLansia")
        jadwalLansiaAdapter = JadwalLansiaAdapter(jadwalLansia, object : JadwalLansiaListener{
            override fun onDetailJadwalLansia(jadwalLansia: Jadwal) {
                startActivity(Intent(activity, DetailJadwalLansiaActivity::class.java).apply{
                    putExtra("jadwal", jadwalLansia)
                })
            }
        })
        binding.rvJadwalLansia.apply{
            adapter = jadwalLansiaAdapter
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
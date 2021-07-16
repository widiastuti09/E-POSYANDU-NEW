package com.example.e_posyandu.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.e_posyandu.R
import com.example.e_posyandu.contracts.JadwalAnakFragmentContract
import com.example.e_posyandu.databinding.FragmentJadwalImunisasiAnakBinding
import com.example.e_posyandu.models.JadwalAnak
import com.example.e_posyandu.presenters.JadwalAnakFragmentPresenter
import com.example.e_posyandu.utilities.Constants


class JadwalImunisasiAnakFragment : Fragment(), JadwalAnakFragmentContract.View {

    private var _binding : FragmentJadwalImunisasiAnakBinding? = null
    private val  binding get() = _binding!!
    private var presenter : JadwalAnakFragmentContract.presenter? = null

    companion object{
        private var idAnak: String? = null
        fun getUserIdAnak(idAnak: String): JadwalImunisasiAnakFragment {
            val fragment = JadwalImunisasiAnakFragment()
            this.idAnak = idAnak
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJadwalImunisasiAnakBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter = JadwalAnakFragmentPresenter(this)
        return view
    }

    private fun getTokenAndId(){
        val token = Constants.getToken(requireActivity())
        presenter?.getJadwalAnak(token)
    }

    override fun attacthToRecycler(jadwalAnak: List<JadwalAnak>) {
        Log.d("Jadwal Anak", " $jadwalAnak")
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
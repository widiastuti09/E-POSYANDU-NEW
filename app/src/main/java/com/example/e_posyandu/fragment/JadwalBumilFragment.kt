package com.example.e_posyandu.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.e_posyandu.contracts.JadwalBumilFragmentContract
import com.example.e_posyandu.databinding.FragmentJadwalBumilBinding
import com.example.e_posyandu.models.JadwalBumil
import com.example.e_posyandu.presenters.JadwalBumilFragmentPresenter
import com.example.e_posyandu.utilities.Constants


class JadwalBumilFragment : Fragment(), JadwalBumilFragmentContract.View {

    private var _binding : FragmentJadwalBumilBinding? = null
    private val binding get() = _binding!!
    private var presenter : JadwalBumilFragmentContract.presenter? = null

    companion object{
        private var idBumil : String? = null
        fun getIdbumil(idBumil : String) : JadwalBumilFragment{
            val fragment = JadwalBumilFragment()
            this.idBumil = idBumil
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJadwalBumilBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter = JadwalBumilFragmentPresenter(this)
        return view
    }

    private fun getTokenAndId() {
        val token = Constants.getToken(requireActivity())
        presenter?.getJadwalBumil(token)
    }

    override fun attacthToRecycler(jadwalBumil: List<JadwalBumil>) {
        Log.d("Jadwal Bumil", " $jadwalBumil")
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
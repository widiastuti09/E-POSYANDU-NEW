package com.example.e_posyandu.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.e_posyandu.R
import com.example.e_posyandu.contracts.BumilResikoTinggiFragmentContract
import com.example.e_posyandu.databinding.FragmentBumilResikoTinggiBinding
import com.example.e_posyandu.models.IbuHamilResikoTinggi
import com.example.e_posyandu.presenters.BumilResikoTinggiFragmentPresenter
import com.example.e_posyandu.utilities.Constants


class BumilResikoTinggiFragment : Fragment(), BumilResikoTinggiFragmentContract.View {

    private var _binding : FragmentBumilResikoTinggiBinding? = null
    private val binding get() = _binding!!
    private var presenter : BumilResikoTinggiFragmentContract.presenter? = null

    companion object{
        private var idBumil : String? = null
        fun getIdbumil (idBumil : String) : BumilResikoTinggiFragment{
            val fragment = BumilResikoTinggiFragment()
            this.idBumil = idBumil
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentBumilResikoTinggiBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter = BumilResikoTinggiFragmentPresenter(this)
        return view
    }

    private fun getTokenAndId(){
        val token = Constants.getToken(requireActivity())
        presenter?.getDataIbuHamilResikoTinggi(token, idBumil!!)
    }

    override fun attacthToRecycler(bumilResikoTinggi: List<IbuHamilResikoTinggi>) {
        Log.d("BUmil Resti", " $bumilResikoTinggi")
        binding.tvUmurKehamilan.text = bumilResikoTinggi[0].umur_hamil + " Bulan"
        binding.tvGPA.text = bumilResikoTinggi[0].gpa
        binding.tvAsuransi.text = bumilResikoTinggi[0].asuransi
        binding.tvResikoTinggi.text = bumilResikoTinggi[0].resiko_tinggi
        binding.tvHPL.text = bumilResikoTinggi[0].hpl
        binding.tvWaliBumil.text = bumilResikoTinggi[0].wali_bumil

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
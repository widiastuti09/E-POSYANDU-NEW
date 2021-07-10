package com.example.e_posyandu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_posyandu.R
import com.example.e_posyandu.adapters.CatatanLansiaAdapter
import com.example.e_posyandu.contracts.CatatanLansiaFragmentContract
import com.example.e_posyandu.databinding.ActivityDetailCatatanLansiaBinding
import com.example.e_posyandu.databinding.FragmentCatatanLansiaBinding
import com.example.e_posyandu.models.Lansia
import com.example.e_posyandu.presenters.CatatanBumilPresenter
import com.example.e_posyandu.presenters.CatatanLansiaPresenter
import com.example.e_posyandu.utilities.Constants


class CatatanLansiaFragment : Fragment(), CatatanLansiaFragmentContract.View {

    private lateinit var _binding: FragmentCatatanLansiaBinding
    private val binding get() = _binding!!

    private var presenter : CatatanLansiaFragmentContract.presenter? = null
    private lateinit var lansiaAdapter : CatatanLansiaAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatatanLansiaBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter = CatatanLansiaPresenter(this)
        return view
    }

    fun getToken(){
        val token = Constants.getToken(requireActivity())
        presenter?.getDataLansia(token)
    }

    override fun attacthToRecycler(lansia: List<Lansia>) {
        binding.rvDaftarLansia.apply{
            lansiaAdapter = CatatanLansiaAdapter(lansia, requireActivity())
            layoutManager = LinearLayoutManager(activity)
            adapter = lansiaAdapter
        }
    }

    override fun showLoading() {
        binding.loadingDaftarLansia.apply{
            isIndeterminate = true
        }
    }

    override fun hideLoading() {
        binding.loadingDaftarLansia.apply{
            isIndeterminate = false
            progress = 0
            visibility = View.GONE
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        getToken()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroy()
    }


}
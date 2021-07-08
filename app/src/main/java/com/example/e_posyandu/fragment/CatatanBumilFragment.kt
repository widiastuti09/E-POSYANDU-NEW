package com.example.e_posyandu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_posyandu.R
import com.example.e_posyandu.adapters.CatatanBumilAdapter
import com.example.e_posyandu.contracts.CatatanBumilActivityContract
import com.example.e_posyandu.databinding.FragmentCatatanBumilBinding
import com.example.e_posyandu.models.IbuHamil
import com.example.e_posyandu.presenters.CatatanBumilPresenter
import com.example.e_posyandu.utilities.Constants


class CatatanBumilFragment : Fragment(), CatatanBumilActivityContract.View {

    private var _binding : FragmentCatatanBumilBinding? = null
    private val binding get() = _binding!!

    private var presenter : CatatanBumilActivityContract.presenter? = null
    private lateinit var bumilAdapter : CatatanBumilAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatatanBumilBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter = CatatanBumilPresenter(this@CatatanBumilFragment)
        return view
    }

    private fun getIbuHamil(){
        val token = Constants.getToken(requireActivity())
        presenter?.getDataIbuHamil(token)
    }

    override fun attacthToRecycler(bumil: List<IbuHamil>) {
        binding.rvDaftarIbuHamil.apply {
            bumilAdapter = CatatanBumilAdapter(bumil, requireActivity())
            val mlayoutManager = LinearLayoutManager(activity)
            layoutManager = mlayoutManager
            adapter = bumilAdapter
        }
    }

    override fun showLoading() {
        binding.loadingDaftarBumil.apply{
            isIndeterminate = true
        }
    }

    override fun hideLoading() {
        binding.loadingDaftarBumil.apply {
            isIndeterminate = false
            progress = 0
            visibility = View.GONE
        }
    }

    override fun showToast(message: String) = Toast.makeText(activity, message, Toast.LENGTH_LONG).show()

    override fun onResume() {
        super.onResume()
        getIbuHamil()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroy()
    }
}
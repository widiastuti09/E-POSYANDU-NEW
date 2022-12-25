package com.example.e_posyandu.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_posyandu.DetailPenimbanganActivity
import com.example.e_posyandu.R
import com.example.e_posyandu.adapters.PenimbanganAnakAdapter
import com.example.e_posyandu.adapters.StatusImunisasiAdapter
import com.example.e_posyandu.adapters.onPenimbanganAnakListener
import com.example.e_posyandu.adapters.onStatusImunisasiListener
import com.example.e_posyandu.contracts.StatusImunisasiFragmentContract
import com.example.e_posyandu.databinding.FragmentImunisasiAnakBinding
import com.example.e_posyandu.databinding.FragmentJadwalAnakBinding
import com.example.e_posyandu.databinding.FragmentStatusImunisasiBinding
import com.example.e_posyandu.models.PenimbanganAnak
import com.example.e_posyandu.models.StatusImunisasi
import com.example.e_posyandu.presenters.JadwalAnakFragmentPresenter
import com.example.e_posyandu.presenters.StatusImunisasiPresenter
import com.example.e_posyandu.utilities.Constants

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StatusImunisasiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StatusImunisasiFragment : Fragment(), StatusImunisasiFragmentContract.View {

    private var _binding : FragmentStatusImunisasiBinding? = null
    private val  binding get() = _binding!!
    private var presenter : StatusImunisasiFragmentContract.presenter? = null
    private lateinit var statusImunisasiAdapter : StatusImunisasiAdapter

    companion object{
        private var idAnak: String? = null
        fun getUserIdAnak(idAnak: String): StatusImunisasiFragment {
            val fragment = StatusImunisasiFragment()
            this.idAnak = idAnak
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private fun getTokenandId(){
        val token = Constants.getToken(requireActivity())
        presenter?.getStatusImunisasi(token, idAnak!!)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatusImunisasiBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter = StatusImunisasiPresenter(this)
        return view
    }

    override fun attacthToRecycler(statusImunisasi: List<StatusImunisasi>) {
        statusImunisasiAdapter = StatusImunisasiAdapter(statusImunisasi, object: onStatusImunisasiListener{
            override fun onStatusImunisasi(statusImunisasi: StatusImunisasi) {

            }

        })

        binding.rvImunisasi.apply{
            val mlayoutManager = LinearLayoutManager(activity)
            layoutManager = mlayoutManager
            adapter = statusImunisasiAdapter
        }
    }

    override fun showLoading() {
        binding.Loading.apply{
            isIndeterminate = true
        }
    }

    override fun hideLoading() {
        binding.Loading.apply{
            isIndeterminate = false
            progress = 0
            visibility = View.GONE
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG). show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroy()
    }
    override fun onResume() {
        super.onResume()
        getTokenandId()
    }
}
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
import com.example.e_posyandu.DetailPemeriksaanBumilActivity
import com.example.e_posyandu.DetailRestiBumilActivity
import com.example.e_posyandu.adapters.PemeriksaanBumilFragmentAdapter
import com.example.e_posyandu.adapters.onPemeriksaanBumilListener
import com.example.e_posyandu.contracts.PemeriksaanBumilFragmentContract
import com.example.e_posyandu.databinding.FragmentPemeriksaanBumilBinding
import com.example.e_posyandu.models.PemeriksaanBumil
import com.example.e_posyandu.presenters.PemeriksaanBumilFragmentPresenter
import com.example.e_posyandu.utilities.Constants


class PemeriksaanBumilFragment : Fragment(), PemeriksaanBumilFragmentContract.View {

    private var _binding : FragmentPemeriksaanBumilBinding? = null
    private val  binding get() = _binding!!
    private var presenter : PemeriksaanBumilFragmentContract.presenter? = null
    private lateinit var adapterPemeriksaanBumil: PemeriksaanBumilFragmentAdapter

    companion object{
        private var idBumil : String? = null
        fun getIdBumil(idBumil : String): PemeriksaanBumilFragment{
            val fragment = PemeriksaanBumilFragment()
            this.idBumil = idBumil
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPemeriksaanBumilBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter = PemeriksaanBumilFragmentPresenter(this)
        return view
    }

    private fun getTokenandId(){
        val token = Constants.getToken(requireActivity())
        presenter?.getDataPemeriksaanBumil(token, idBumil!!)
    }

    override fun attacthToView(pemeriksaanBumil: List<PemeriksaanBumil>) {
        if (pemeriksaanBumil != null){
            adapterPemeriksaanBumil = PemeriksaanBumilFragmentAdapter(pemeriksaanBumil, object: onPemeriksaanBumilListener{
                override fun onDetailClick(pemeriksaan: PemeriksaanBumil) {
                    val intentRestiBumilDetail = Intent(activity, DetailPemeriksaanBumilActivity::class.java).apply{
                        putExtra("PEMERIKSAAN_BUMIL", pemeriksaan)
                    }
                    activity!!.startActivity(intentRestiBumilDetail)
                }

            })
            binding.rvPemeriksaanBumil.apply {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = adapterPemeriksaanBumil
            }
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

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroy()
    }

    override fun onResume() {
        super.onResume()
        getTokenandId()
    }
}
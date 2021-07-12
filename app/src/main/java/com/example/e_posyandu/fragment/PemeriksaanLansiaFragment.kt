package com.example.e_posyandu.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_posyandu.DetailPemeriksaanLansiaActivity
import com.example.e_posyandu.adapters.PemeriksaanLansiaAdapter
import com.example.e_posyandu.adapters.onPemeriksaanLansiaListener
import com.example.e_posyandu.databinding.FragmentPemeriksaanLansiaBinding
import com.example.e_posyandu.models.PemeriksaanLansia
import com.example.e_posyandu.responses.WrappedListResponse
import com.example.e_posyandu.utilities.APIClient
import com.example.e_posyandu.utilities.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PemeriksaanLansiaFragment : Fragment() {
    private var _binding: FragmentPemeriksaanLansiaBinding? = null
    private val binding get() = _binding!!
    private lateinit var pemeriksaanLansiaAdapter: PemeriksaanLansiaAdapter

    companion object {
        private var idLansia: String? = null
        fun getIdLansia(idLansia: String): PemeriksaanLansiaFragment {
            val fragment = PemeriksaanLansiaFragment()
            this.idLansia = idLansia
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPemeriksaanLansiaBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    private fun getTokenandIdLansia() {
        val token = Constants.getToken(requireActivity())
        getPemeriksaanLansia(token, idLansia!!)
    }

    private fun getPemeriksaanLansia(token: String, id: String) {
        APIClient.APIService().getPemeriksaanLansia("Bearer " +token, id).enqueue(object :
            Callback<WrappedListResponse<PemeriksaanLansia>> {
            override fun onResponse(
                call: Call<WrappedListResponse<PemeriksaanLansia>>,
                response: Response<WrappedListResponse<PemeriksaanLansia>>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null && body.status.equals(200)) {
                        showDatatoRecycler(body.data)
                    }
                }
            }

            override fun onFailure(
                call: Call<WrappedListResponse<PemeriksaanLansia>>,
                t: Throwable
            ) {
                Log.e("Salah gblk", "${t.message}")
            }
        })
    }

    private fun showDatatoRecycler(data: List<PemeriksaanLansia>) {
        pemeriksaanLansiaAdapter =
            PemeriksaanLansiaAdapter(data, object : onPemeriksaanLansiaListener {
                override fun onDetailClick(pemeriksaan: PemeriksaanLansia) {
                    startActivity(
                        Intent(activity, DetailPemeriksaanLansiaActivity::class.java).apply {
                            putExtra("DetailpemeriksaanLansia", pemeriksaan)
                        })
                }
            })
        binding.rvPemeriksaanLansia.apply {
            adapter = pemeriksaanLansiaAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        Log.d("Data Pemeriksaan Lansia ", "$data ")
    }

    override fun onResume() {
        super.onResume()
        getTokenandIdLansia()
    }
}


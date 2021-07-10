package com.example.e_posyandu.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_posyandu.DetailCatatanAnakActivity
import com.example.e_posyandu.adapters.CatatanAnakAdapter
import com.example.e_posyandu.adapters.onAdapterClick
import com.example.e_posyandu.contracts.CatatanAnakActivityContract
import com.example.e_posyandu.databinding.FragmentCatatanAnakBinding
import com.example.e_posyandu.models.Anak
import com.example.e_posyandu.presenters.CatatanAnakPresenter
import com.example.e_posyandu.utilities.Constants


class CatatanAnakFragment : Fragment(), CatatanAnakActivityContract.View{

    private var _binding : FragmentCatatanAnakBinding? = null
    private val binding get() = _binding!!
    private var presenter : CatatanAnakActivityContract.presenter? = null
    private lateinit var anakAdapter : CatatanAnakAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCatatanAnakBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter = CatatanAnakPresenter(this@CatatanAnakFragment)
        return view
    }

    private fun getAnak(){
        val token = Constants.getToken(requireActivity())
        presenter?.getDataAnak(token)
    }

    override fun attacthToRecycler(anak: List<Anak>) {
        binding.rvDaftarAnak.apply {
            anakAdapter = CatatanAnakAdapter(anak, requireActivity(), object : onAdapterClick{
                override fun onDetailAnak(anak: Anak) {
                    startActivity(Intent(activity, DetailCatatanAnakActivity::class.java).apply{
                        putExtra("userIdAnak", anak.id)
                    })
                }


            })
            val mlayoutManager = LinearLayoutManager(activity)
            layoutManager = mlayoutManager
            adapter = anakAdapter
        }
    }

    override fun showLoading() {
        binding.loadingDaftarAnak.apply{
            isIndeterminate = true
        }
    }

    override fun hideLoading() {
        binding.loadingDaftarAnak.apply {
            isIndeterminate = false
            progress = 0
            visibility = View.GONE
        }
    }

    override fun showToast(message: String) = Toast.makeText(activity, message, Toast.LENGTH_LONG). show()

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroy()
    }

    override fun onResume() {
        super.onResume()
        getAnak()
    }




}
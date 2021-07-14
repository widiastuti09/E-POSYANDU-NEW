package com.example.e_posyandu.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_posyandu.DetailPenimbanganActivity
import com.example.e_posyandu.adapters.PenimbanganAnakAdapter
import com.example.e_posyandu.adapters.onPenimbanganAnakListener
import com.example.e_posyandu.contracts.PenimbanganAnakFragmentContract
import com.example.e_posyandu.databinding.FragmentPenimbanganAnakBinding
import com.example.e_posyandu.models.PenimbanganAnak
import com.example.e_posyandu.presenters.PenimbanganAnakFragmentPresenter
import com.example.e_posyandu.utilities.Constants


class PenimbanganAnakFragment : Fragment(),PenimbanganAnakFragmentContract.View {

    private var _binding : FragmentPenimbanganAnakBinding? = null
    private val binding get() = _binding!!
    private var presenter : PenimbanganAnakFragmentContract.presenter? = null
    private lateinit var penimbanganAdapter : PenimbanganAnakAdapter

    companion object{
        private var idAnak: String? = null
        fun getUserIdAnak(idAnak: String): PenimbanganAnakFragment {
            val fragment = PenimbanganAnakFragment()
            this.idAnak = idAnak
            return fragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPenimbanganAnakBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        println("id Penimbangan = $idAnak")
        presenter = PenimbanganAnakFragmentPresenter(this)
        return view
    }

    private fun getTokenandId(){
        val token = Constants.getToken(requireActivity())
        presenter?.getDataPenimbanganAnak(token, idAnak!!)

    }

    override fun attacthToRecycler(penimbangan: List<PenimbanganAnak>) {
        penimbanganAdapter = PenimbanganAnakAdapter(penimbangan, object : onPenimbanganAnakListener{
            override fun onDetailClick(penimbangan: PenimbanganAnak) {
                startActivity(Intent(activity, DetailPenimbanganActivity::class.java).apply{
                    putExtra("penimbangan", penimbangan)
                })
            }
        })
        binding.rvPenimbangan.apply{
            val mlayoutManager = LinearLayoutManager(activity)
            layoutManager = mlayoutManager
            adapter = penimbanganAdapter
        }
        Log.d("Penimbangan Anak", "$penimbangan ")
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
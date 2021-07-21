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
import com.example.e_posyandu.DetailRestiBumilActivity
import com.example.e_posyandu.R
import com.example.e_posyandu.adapters.RestiBumilAdapter
import com.example.e_posyandu.adapters.onClickRestiBumil
import com.example.e_posyandu.contracts.BumilResikoTinggiFragmentContract
import com.example.e_posyandu.databinding.FragmentBumilResikoTinggiBinding
import com.example.e_posyandu.models.IbuHamilResikoTinggi
import com.example.e_posyandu.presenters.BumilResikoTinggiFragmentPresenter
import com.example.e_posyandu.utilities.Constants


class BumilResikoTinggiFragment : Fragment(), BumilResikoTinggiFragmentContract.View {

    private var _binding : FragmentBumilResikoTinggiBinding? = null
    private val binding get() = _binding!!
    private var presenter : BumilResikoTinggiFragmentContract.presenter? = null
    private lateinit var adapterRestiBumilFragment: RestiBumilAdapter

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
        adapterRestiBumilFragment = RestiBumilAdapter(bumilResikoTinggi, object :  onClickRestiBumil {
            override fun onClickDetail(restiBumil: IbuHamilResikoTinggi) {
                val intentRestiBumilDetail = Intent(activity, DetailRestiBumilActivity::class.java).apply{
                    putExtra("DETAIL_RESTI", restiBumil)
                }
                activity!!.startActivity(intentRestiBumilDetail)
            }

        })

        binding.rvBumilResti.apply {
            adapter = adapterRestiBumilFragment
            layoutManager = LinearLayoutManager(requireActivity())
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

    override fun emptyData() {
        binding.emptyData.visibility = View.VISIBLE
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
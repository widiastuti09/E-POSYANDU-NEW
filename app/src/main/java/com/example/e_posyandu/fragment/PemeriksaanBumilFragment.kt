package com.example.e_posyandu.fragment
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.e_posyandu.contracts.PemeriksaanBumilFragmentContract
import com.example.e_posyandu.databinding.FragmentPemeriksaanBumilBinding
import com.example.e_posyandu.models.PemeriksaanBumil
import com.example.e_posyandu.presenters.PemeriksaanBumilFragmentPresenter
import com.example.e_posyandu.utilities.Constants


class PemeriksaanBumilFragment : Fragment(), PemeriksaanBumilFragmentContract.View {

    private var _binding : FragmentPemeriksaanBumilBinding? = null
    private val  binding get() = _binding!!
    private var presenter : PemeriksaanBumilFragmentContract.presenter? = null

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
            val hemoglobin = pemeriksaanBumil[0].hemoglobin_atas + "/" + pemeriksaanBumil[0].hemoglobin_bawah
            binding.tvTinggiBadan.text = pemeriksaanBumil[0].tinggibadan + " Cm"
            binding.tvHemoglobin.text = hemoglobin
            binding.tvHTP.text = pemeriksaanBumil[0].htp
            binding.tvHPHT.text = pemeriksaanBumil[0].hpht
            binding.tvBeratBadan.text = pemeriksaanBumil[0].beratbadan + " Kg"
            binding.tvHamilKe.text = pemeriksaanBumil[0].hamilke
            binding.tvPersalinanKe.text = pemeriksaanBumil[0].persalinanke
            binding.tvJumlahKeguguran.text = pemeriksaanBumil[0].keguguranke
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
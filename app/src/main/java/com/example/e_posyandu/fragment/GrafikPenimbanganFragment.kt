package com.example.e_posyandu.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.e_posyandu.R
import com.example.e_posyandu.databinding.FragmentGrafikPenimbanganBinding
import com.example.e_posyandu.databinding.FragmentJadwalAnakBinding
import com.example.e_posyandu.models.PenimbanganAnak
import com.example.e_posyandu.models.StatusImunisasi
import com.example.e_posyandu.responses.WrappedListResponse
import com.example.e_posyandu.utilities.APIClient
import com.example.e_posyandu.utilities.Constants
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.*
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.fragment_grafik_penimbangan.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "idAnak"

/**
 * A simple [Fragment] subclass.
 * Use the [GrafikPenimbanganFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GrafikPenimbanganFragment : Fragment() {

    private lateinit var lineChart: LineChart

    private var _binding: FragmentGrafikPenimbanganBinding? = null
    private val binding get() = _binding!!
    private lateinit var token: String

    private var apiServices = APIClient.APIService()

    fun loadData() {
        print("loaddata" + idAnak)
        val request = apiServices.getPenimbanganAnak("Bearer " + token, idAnak!!)
        showLoading()
        request.enqueue(object : Callback<WrappedListResponse<PenimbanganAnak>> {
            override fun onResponse(
                call: Call<WrappedListResponse<PenimbanganAnak>>,
                response: Response<WrappedListResponse<PenimbanganAnak>>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null && body.status.equals(200)) {
                        populateDataToChart(body.data)
                    }
                } else {
                    showToast("Terjadi kesalahan, silahkan coba lagi lain waktu")
                }
                hideLoading()
            }

            override fun onFailure(call: Call<WrappedListResponse<PenimbanganAnak>>, t: Throwable) {
                showToast("Tidak bisa koneksi ke server")
                hideLoading()
            }

        })
    }

    fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGrafikPenimbanganBinding.inflate(inflater, container, false)
        val view = binding.root
        getTokenandId()
        loadData()
        return view
    }

    fun populateDataToChart(listPenimbanganAnak: List<PenimbanganAnak>) {
        lineChart = binding.tvLineChart

        lineChart.description.isEnabled = false
//        lineChart.setDrawGridBackground(false)
//        lineChart.setDrawBorders(false)
//        lineChart.getAxisLeft().setEnabled(false)
//        lineChart.getAxisRight().setDrawAxisLine(false)
        lineChart.axisRight.setDrawGridLines(false)
//        lineChart.getXAxis().setDrawAxisLine(false)
        lineChart.xAxis.setDrawGridLines(false)
//        lineChart.setTouchEnabled(true) // enable touch gestures. Allows to enable/disable all possible touch-interactions with the chart.
//        lineChart.setDragEnabled(true) // enable scaling and dragging
//        lineChart.setScaleEnabled(true) //Enables/disables scaling for the chart on both axes.
//        lineChart.setScaleXEnabled(true) //Enables/disables scaling on the x-axis and y-axis
//        lineChart.setPinchZoom(false) // if disabled, scaling can be done on x- and y-axis can be zoomed separately
//        lineChart.axisLeft.isEnabled = false
//        lineChart.axisLeft.spaceTop = 40f
//        lineChart.axisLeft.spaceBottom = 40f
//        lineChart.axisRight.isEnabled = false
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        lineChart.xAxis.setDrawGridLines(true);
//        lineChart.xAxis.granularity = 1f;

        val yAxis: YAxis = lineChart.axisLeft;

        yAxis.mAxisRange = 20f
        yAxis.textSize = 12f
        yAxis.labelCount = 20
        yAxis.granularity = 1f

        lineChart.xAxis.axisMaximum = 24f
        lineChart.xAxis.textSize = 12f
        lineChart.setVisibleXRangeMaximum(10f)
        lineChart.xAxis.labelRotationAngle = 65f
        lineChart.xAxis.labelCount = 20
        lineChart.xAxis.granularity = 1F
        lineChart.xAxis.axisMinimum = 0f

        //Setting Legend
        val legend = lineChart.legend
        legend.isEnabled = true
        legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        legend.orientation = Legend.LegendOrientation.HORIZONTAL
        legend.setDrawInside(false)

        val kasus = ArrayList<Entry>()
        for (i in listPenimbanganAnak.indices) {
            kasus.add(Entry(i.toFloat(), listPenimbanganAnak[i].beratbadan!!.toFloat()))
        }

        val kasusLineDataSet = LineDataSet(kasus, "Berat Badan")
        kasusLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        kasusLineDataSet.color = R.color.main_color
        kasusLineDataSet.circleRadius = 5f
        kasusLineDataSet.setCircleColor(R.color.main_color)
        kasusLineDataSet.lineWidth = 4f
        kasusLineDataSet.valueTextSize = 10f

        val date = ArrayList<String>()

        for (i in listPenimbanganAnak.indices) {
            date.add(listPenimbanganAnak[i].tanggal!! + " ( " + listPenimbanganAnak[i].umur!! + " bln )")
        }

        val tanggal = AxisDateFormatter(date.toArray(arrayOfNulls<String>(date.size)))
        lineChart.xAxis?.setValueFormatter(tanggal);

        lineChart.data = LineData(kasusLineDataSet)
        lineChart.animateXY(100, 500)
    }

    companion object {
        private var idAnak: String? = null

        fun newInstance(idAnak: String): StatusImunisasiFragment {
            val fragment = StatusImunisasiFragment()
            this.idAnak = idAnak
            return fragment
        }
    }

    fun showLoading() {
        binding.loading.apply {
            isIndeterminate = true
        }
    }

    fun hideLoading() {
        binding.loading.apply {
            isIndeterminate = false
            progress = 0
            visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun getTokenandId() {
        token = Constants.getToken(requireActivity())
    }

    override fun onResume() {
        super.onResume()
        getTokenandId()
        loadData()
    }

}

class AxisDateFormatter(private val mValues: Array<String>) : ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        val index = value.toInt()
        return if (index < mValues.size) {
            mValues[index]
        } else {
            "-"
        }
//        return if (value >= 0) {
//            if (mValues.size > value.toInt()) {
//                mValues[value.toInt()]
//            } else "x"
//        } else {
//            "x"
//        }
    }
}
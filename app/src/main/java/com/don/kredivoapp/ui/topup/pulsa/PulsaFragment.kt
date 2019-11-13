package com.don.kredivoapp.ui.topup.pulsa


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.don.kredivoapp.data.PromoEntity
import kotlinx.android.synthetic.main.fragment_pulsa.*
import androidx.recyclerview.widget.PagerSnapHelper
import com.don.kredivoapp.R
import com.don.kredivoapp.data.TopUpEntity


/**
 * A simple [Fragment] subclass.
 */
class PulsaFragment : Fragment(),PromoAdapter.OnClickItem,PulsaAdapter.OnClickItem{



    private lateinit var promoAdapter: PromoAdapter
    private lateinit var pulsaAdapter: PulsaAdapter
    private lateinit var viewModel: PulsaViewModel
    private lateinit var listPromos: ArrayList<PromoEntity>
    private lateinit var listTopUp: ArrayList<TopUpEntity>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pulsa, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PulsaViewModel::class.java)
        setupPulsa()
        setupPromo()
    }


    private fun setupPromo(){
        listPromos = viewModel.getPromos()
        promoAdapter = PromoAdapter(listPromos, activity!!, this)
        rv_promo.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL ,false)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_promo)
        rv_promo.setHasFixedSize(true)
        rv_promo.adapter = promoAdapter
    }
    private fun setupPulsa(){
        listTopUp = viewModel.getPulsas()
        pulsaAdapter = PulsaAdapter(listTopUp, activity!!, this)
        rv_pulsa.layoutManager = LinearLayoutManager(context)
        rv_pulsa.setHasFixedSize(true)
        rv_pulsa.adapter = pulsaAdapter
    }

    override fun onClickView(item: PromoEntity) {
    }

    override fun onClickView(item: TopUpEntity) {
    }
}

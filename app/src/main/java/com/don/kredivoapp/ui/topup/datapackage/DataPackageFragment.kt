package com.don.kredivoapp.ui.topup.datapackage


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.don.kredivoapp.R
import com.don.kredivoapp.data.PromoEntity
import com.don.kredivoapp.data.TopUpEntity
import com.don.kredivoapp.ui.promo.PromoActivity
import com.don.kredivoapp.ui.topup.pulsa.PromoAdapter
import kotlinx.android.synthetic.main.fragment_data_package.*

/**
 * A simple [Fragment] subclass.
 */
class DataPackageFragment : Fragment(), DataPackageAdapter.OnClickItem, PromoAdapter.OnClickItem {

    private lateinit var adapter: DataPackageAdapter
    private lateinit var promoAdapter: PromoAdapter
    private lateinit var viewModel: DataPackageViewModel
    private lateinit var listTopUp: ArrayList<TopUpEntity>
    private lateinit var listPromos: ArrayList<PromoEntity>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_package, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DataPackageViewModel::class.java)
        setupDataPackage()
        setupPromo()
    }

    private fun setupDataPackage() {
        listTopUp = viewModel.getDataPackage()
        adapter = DataPackageAdapter(listTopUp, activity!!, this)
        rv_data_package.layoutManager = LinearLayoutManager(context)
        rv_data_package.setHasFixedSize(true)
        rv_data_package.adapter = adapter
    }

    private fun setupPromo() {
        listPromos = viewModel.getPromos()
        promoAdapter = PromoAdapter(listPromos, activity!!, this)
        rv_promo_data.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_promo_data)
        rv_promo_data.setHasFixedSize(true)
        rv_promo_data.adapter = promoAdapter
    }

    override fun onClickView(item: PromoEntity) {
        val intent = Intent(activity, PromoActivity::class.java)
        intent.putExtra(
            PromoActivity.EXTRA_ID,
            item.id
        )
        startActivity(intent)
    }

    override fun onClickView(item: TopUpEntity) {
    }

}

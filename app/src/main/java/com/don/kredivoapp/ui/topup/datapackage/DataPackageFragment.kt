package com.don.kredivoapp.ui.topup.datapackage


import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.don.kredivoapp.R
import com.don.kredivoapp.base.BaseFragment
import com.don.kredivoapp.data.PromoEntity
import com.don.kredivoapp.data.TopUpEntity
import com.don.kredivoapp.ui.promo.PromoActivity
import com.don.kredivoapp.ui.topup.pulsa.PromoAdapter
import com.don.kredivoapp.utils.PhoneNumberUtils
import kotlinx.android.synthetic.main.fragment_data_package.*

/**
 * A simple [Fragment] subclass.
 */
class DataPackageFragment : BaseFragment(), PromoAdapter.OnClickItem, DataPackageAdapter.OnClickItem {
    private lateinit var promoAdapter: PromoAdapter
    private lateinit var pulsaAdapter: DataPackageAdapter
    private lateinit var viewModel: DataPackageViewModel
    private lateinit var listPromos: ArrayList<PromoEntity>
    private lateinit var listTopUp: ArrayList<TopUpEntity>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        context?.theme?.applyStyle(R.style.colorControlRippleBlue, true); //blue ripple color

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_package, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DataPackageViewModel::class.java)
        setupDataPackage()
        setupPromo()

        tv_mobile_data.setOnClickListener {
            showEditText(context!!)
        }

        iv_close_data.setOnClickListener {
            tv_mobile_data.text = ""
            iv_close_data.visibility = View.INVISIBLE
            rv_data_package.visibility = View.INVISIBLE
            iv_data_package.visibility = View.INVISIBLE
        }

        btn_contact_data.setOnClickListener {
            getContactData()
        }
    }

    private fun setupPromo() {
        listPromos = viewModel.getPromos()
        promoAdapter = PromoAdapter(listPromos, activity!!, this)
        rv_promo_data.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_promo_data)
        rv_promo_data.setHasFixedSize(true)
        rv_promo_data.adapter = promoAdapter
    }

    private fun setupDataPackage() {
        listTopUp = viewModel.getDataPackage()
        pulsaAdapter = DataPackageAdapter(listTopUp, activity!!, this)
        rv_data_package.layoutManager = LinearLayoutManager(context)
        rv_data_package.setHasFixedSize(true)
        rv_data_package.adapter = pulsaAdapter
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

    private fun showEditText(context: Context) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) //before
        dialog.setContentView(R.layout.dialog_edit_text)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()

        val etPhoneNumber = dialog.findViewById(R.id.et_phone_number) as EditText
        etPhoneNumber.setText(tv_mobile_data.text.toString().trim())
        etPhoneNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                val etValue = etPhoneNumber.text.toString().trim()
                if (etValue.length >= 4) {
                    try {
                        val firstFourDigits = etValue.substring(0, Math.min(etValue.length, 4))
                        //check phone number based on prefix
                        PhoneNumberUtils.checkPhoneNumber(
                            context,
                            firstFourDigits,
                            iv_data_package,
                            rv_data_package,
                            constraint_data
                        )
//                        Log.d(TAG, firstFourDigits)
                    } catch (e: Exception) {
                    }
                }
                tv_mobile_data.text = etPhoneNumber.text.toString().trim()
                if (etValue.length >= 1) {
                    iv_close_data.visibility = View.VISIBLE
                } else {
                    iv_close_data.visibility = View.INVISIBLE
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
        val btnOk = dialog.findViewById(R.id.btn_ok) as Button
        btnOk.setOnClickListener {
            hideSoftKeyboard()
            dialog.hide()
        }
    }

}
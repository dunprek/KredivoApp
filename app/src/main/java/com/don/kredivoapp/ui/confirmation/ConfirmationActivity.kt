package com.don.kredivoapp.ui.confirmation

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.don.kredivoapp.R
import com.don.kredivoapp.base.BaseActivity
import com.don.kredivoapp.data.OrderMdl
import com.don.kredivoapp.utils.GlideUtils
import com.don.kredivoapp.utils.SnackBarUtils
import kotlinx.android.synthetic.main.activity_confirmation.*

class ConfirmationActivity : BaseActivity() {

    companion object {
        const val EXTRA_ITEM = "extra_item"
        const val EXTRA_FROM = "extra_from"
    }

    private var confirmationMdl: OrderMdl? = null

    private var selectedID = ""
    private var fromFragment = ""

    lateinit var viewModel: ConfirmationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        //declare view model
        viewModel = ViewModelProviders.of(this)
            .get(ConfirmationViewModel::class.java)

        //get intent extra
        val extras = intent.extras
        if (extras != null) {
            selectedID = extras.getString(EXTRA_ITEM)!!
            fromFragment = extras.getString(EXTRA_FROM)!!
        }

        //set selected id to viewModel
        viewModel.setSelectedId(selectedID)

        //check origin
        if (fromFragment == "PULSA") {
            populateConfirmation(viewModel.getPulsaOrder(this))
        } else {
            populateConfirmation(viewModel.getDataPackageOrder(this))
        }

        et_pin.onFocusChangeListener = (object : View.OnFocusChangeListener {
            override fun onFocusChange(p0: View?, hasFocus: Boolean) {
                if (hasFocus) {
                    et_pin.hint = "Pin"
                } else {
                    et_pin.hint = ""
                }
            }
        })

        //set different color of text
        setSpannable()
        tv_loan_agreement.setOnClickListener {
            SnackBarUtils.showSnackBar(constraint_confirmation, "Menuju Ke Agreement")
        }

        btn_pay.setOnClickListener {
            if (checkET(et_pin)) {
                confirmationMdl?.orderStatus = "success"
                val intent = Intent(this, ConfirmationActivity::class.java)
//                intent.putExtra(EXTRA_OBJECT, confirmationMdl)
                startActivity(intent)
            }
        }
    }

    private fun setSpannable() {
        val spannable = SpannableString(getString(R.string.label_loan_agreement))
        spannable.setSpan(
            ForegroundColorSpan(Color.BLUE),
            28, 53,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tv_loan_agreement.text = spannable
    }

    private fun populateConfirmation(orderMdl: OrderMdl?) {
        if (orderMdl != null) {
            tv_mobile_number.text = orderMdl.phoneNumber
            GlideUtils.glideCircle(this@ConfirmationActivity, orderMdl.image, iv_pulsa)
            tv_pulsa_name.text = orderMdl.type
            tv_price.text = formatRupiah(orderMdl.price)
            tv_admin_fee.text = formatRupiah(orderMdl.adminFee)
            tv_total_price.text = formatRupiah(orderMdl.total)
        }
    }

}

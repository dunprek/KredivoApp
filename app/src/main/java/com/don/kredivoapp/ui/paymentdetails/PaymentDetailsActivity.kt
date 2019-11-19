package com.don.kredivoapp.ui.paymentdetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.MenuItem
import com.don.kredivoapp.R
import com.don.kredivoapp.base.BaseActivity
import com.don.kredivoapp.data.OrderMdl
import com.don.kredivoapp.ui.confirmation.ConfirmationActivity
import com.don.kredivoapp.ui.topup.TopUpActivity
import com.don.kredivoapp.utils.GlideUtils
import kotlinx.android.synthetic.main.activity_payment_details.*


class PaymentDetailsActivity : BaseActivity() {

    private var confirmationMdl: OrderMdl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_details)
        setToolbarClose("Payment Details")
        if (intent != null) {
            confirmationMdl = intent.getParcelableExtra(ConfirmationActivity.EXTRA_OBJECT)
        }

        setSpannable()

        setupView(confirmationMdl)

        tv_support.setOnClickListener {
            //            showSnackBar("Menuju Support")
            val emailIntent = Intent(
                Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "support@kredivo.com", null
                )
            )
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Mohon Bantuan Mengenai")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Ini test Isi ")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }

        btn_pay.setOnClickListener {
            val intent = Intent(this, TopUpActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    private fun setSpannable() {
        val spannable = SpannableString(getString(R.string.label_support))
        spannable.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.colorDarkBlue)),
            58, 77,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tv_support.text = spannable
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent(this, TopUpActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupView(orderMdl: OrderMdl?) {
        if (orderMdl != null) {
            tv_mobile_number.text = orderMdl.phoneNumber
            GlideUtils.glideCircle(this@PaymentDetailsActivity, orderMdl.image, iv_payment)
            tv_status.text = orderMdl.orderStatus
            tv_order_id.text = formatCode(orderMdl.orderId)
            tv_type.text = orderMdl.type
            tv_payment_method.text = orderMdl.paymentMethod
            tv_price.text = formatRupiah(orderMdl.price)
            tv_admin_fee.text = formatRupiah(orderMdl.adminFee)
            tv_total_price.text = formatRupiah(orderMdl.total)
        }
    }
}

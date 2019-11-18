package com.don.kredivoapp.ui.paymentdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.don.kredivoapp.R
import com.don.kredivoapp.base.BaseActivity
import com.don.kredivoapp.data.OrderMdl
import com.don.kredivoapp.ui.confirmation.ConfirmationActivity
import org.apache.commons.lang3.RandomStringUtils
import org.apache.commons.text.RandomStringGenerator
import java.util.*

class PaymentDetailsActivity : BaseActivity() {

    private var confirmationMdl: OrderMdl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_details)

        val s = RandomStringUtils.randomAlphanumeric(8).toLowerCase(Locale.ENGLISH)

        showSnackBar(s)

      /*  if (intent != null) {
            confirmationMdl = intent.getParcelableExtra(ConfirmationActivity.EXTRA_OBJECT)
        }*/
    }
}

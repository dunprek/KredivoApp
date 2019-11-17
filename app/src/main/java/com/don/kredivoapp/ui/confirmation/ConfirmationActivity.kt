package com.don.kredivoapp.ui.confirmation

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import com.don.kredivoapp.R
import com.don.kredivoapp.base.BaseActivity
import com.don.kredivoapp.utils.SnackBarUtils
import kotlinx.android.synthetic.main.activity_confirmation.*

class ConfirmationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val spannable = SpannableString(getString(R.string.label_loan_agreement))
        spannable.setSpan(
            ForegroundColorSpan(Color.BLUE),
            28, 53,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tv_loan_agreement.text = spannable


        tv_loan_agreement.setOnClickListener {
            SnackBarUtils.showSnackBar(constraint_confirmation, "Menuju Ke Agreement")
        }



        btn_pay.setOnClickListener {
            if (checkET(et_pin,"continued")) {
                Log.e("hero","lulus")
            }
        }

    }


}

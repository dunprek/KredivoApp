package com.don.kredivoapp.ui.promo

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.don.kredivoapp.R
import com.don.kredivoapp.base.BaseActivity
import com.don.kredivoapp.data.PromoEntity
import com.don.kredivoapp.utils.GlideUtils
import kotlinx.android.synthetic.main.activity_promo.*


class PromoActivity : BaseActivity() {
    companion object {
        const val EXTRA_ID = "extra_id"
    }

    lateinit var viewModel: PromoViewModel

    var selectedId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promo)
        setToolbarTitle(getString(R.string.title_promo))
        showBackArrow()

        viewModel = ViewModelProviders.of(this)
            .get(PromoViewModel::class.java)

        val extras = intent.extras
        if (extras != null) {
            selectedId = extras.getString(EXTRA_ID)!!
        }

        viewModel.setSelectedId(selectedId)

        populateDetail(viewModel.getPromo())

        btn_copy.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("label", tv_voucher_code.text.toString().trim())
            clipboard.setPrimaryClip(clip)
            showTopSnackBar("Promo Code Copied")
        }

    }


    private fun populateDetail(promoEntity: PromoEntity?) {
        if (promoEntity != null) {
            GlideUtils.glideNoRoundedCorners(this@PromoActivity, promoEntity.imageUrl, iv_promo)
            tv_name.text = promoEntity.name
            tv_valid_date.text = promoEntity.date
            tv_voucher_code.text = promoEntity.code
            tv_tc.text = Html.fromHtml(promoEntity.tc)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}

package com.don.kredivoapp.ui.promo

import androidx.lifecycle.ViewModel
import com.don.kredivoapp.data.PromoEntity
import com.don.kredivoapp.utils.DataDummy

/**
 * Created by gideon on 20,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class PromoViewModel : ViewModel() {
    private var mPromoEntity: PromoEntity? = null
    private var mSelectedId: String = ""


    fun setSelectedId(selectedId: String) {
        this.mSelectedId = selectedId
    }

    fun getPromo(): PromoEntity? {
        for (i in 0 until DataDummy.generateDummyPromo().size) {
            val promoEntity = DataDummy.generateDummyPromo()[i]
            if (promoEntity.id.equals(mSelectedId)) {
                mPromoEntity = promoEntity
            }
        }
        return mPromoEntity
    }
}
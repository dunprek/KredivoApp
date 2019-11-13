package com.don.kredivoapp.ui.topup.pulsa

import androidx.lifecycle.ViewModel
import com.don.kredivoapp.data.PromoEntity
import com.don.kredivoapp.data.TopUpEntity
import com.don.kredivoapp.utils.DataDummy

/**
 * Created by gideon on 19,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class PulsaViewModel : ViewModel() {
    fun getPulsas(): ArrayList<TopUpEntity> {
        return DataDummy.generateDummyPulsa()
    }

    fun getPromos(): ArrayList<PromoEntity> {
        return DataDummy.generateDummyPromo()
    }
}
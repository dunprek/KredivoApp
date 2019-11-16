package com.don.kredivoapp.ui.topup.datapackage

import androidx.lifecycle.ViewModel
import com.don.kredivoapp.data.PromoEntity
import com.don.kredivoapp.data.TopUpEntity
import com.don.kredivoapp.utils.DataDummy

/**
 * Created by gideon on 19,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class DataPackageViewModel : ViewModel() {
    fun getDataPackage(): ArrayList<TopUpEntity> {
        return DataDummy.generateDummyDataPackage()
    }

    fun getPromos(): ArrayList<PromoEntity> {
        return DataDummy.generateDummyPromo()
    }
}
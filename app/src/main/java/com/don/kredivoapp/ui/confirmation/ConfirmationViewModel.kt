package com.don.kredivoapp.ui.confirmation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.don.kredivoapp.data.OrderMdl
import com.don.kredivoapp.utils.DataDummy
import com.don.kredivoapp.utils.PrefUtils
import org.apache.commons.lang3.RandomStringUtils
import java.util.*

/**
 * Created by gideon on 19,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class ConfirmationViewModel : ViewModel() {
    private var orderMdl: OrderMdl? = null
    private var selectedId: String = ""
    private val randomOrderId = RandomStringUtils.randomAlphanumeric(8).toLowerCase(Locale.ENGLISH)

    fun setSelectedId(selectedId: String) {
        this.selectedId = selectedId
    }

    fun getPulsaOrder(context: Context): OrderMdl? {
        for (i in 0 until DataDummy.generateDummyPulsa().size) {
            val pulsaEntity = DataDummy.generateDummyPulsa()[i]
            if (pulsaEntity.id.toString() == selectedId) {
                orderMdl = OrderMdl(
                    randomOrderId,
                    "pending",
                    PrefUtils.getImageName(context),
                    PrefUtils.getPhoneNumber(context),
                    pulsaEntity.type,
                    pulsaEntity.price,
                    0.0,
                    pulsaEntity.price!!,
                    "30 days"
                )
            }

        }
        return orderMdl
    }

    fun getDataPackageOrder(context: Context): OrderMdl? {
        for (i in 0 until DataDummy.generateDummyDataPackage().size) {
            val dataEntity = DataDummy.generateDummyDataPackage()[i]
            if (dataEntity.id.toString() == selectedId) {
                orderMdl = OrderMdl(
                    randomOrderId,
                    "pending",
                    PrefUtils.getImageName(context),
                    PrefUtils.getPhoneNumber(context),
                    dataEntity.type,
                    dataEntity.price,
                    0.0,
                    dataEntity.price!!,
                    "30 days"
                )
            }
        }
        return orderMdl
    }
}
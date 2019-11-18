package com.don.kredivoapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by gideon on 17,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
data class OrderMdl(
    var orderId: String?,
    var orderStatus: String?,
    var image: String?,
    var phoneNumber: String?,
    var type: String?,
    var price: Double?,
    var adminFee: Double,
    var total: Double,
    var paymentMethod: String?
)
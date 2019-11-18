package com.don.kredivoapp.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by gideon on 14,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
object PhoneNumberUtils {
    private const val IMG_TELKOMSEL = "img_telkomsel"
    private const val IMG_INDOSAT = "img_indosat"
    private const val IMG_THREE = "img_three"
    private const val IMG_AXIS = "img_axis"
    private const val IMG_XL = "img_xl"

    fun checkPhoneNumber(
        context: Context,
        value: String,
        imageView: ImageView,
        recyclerView: RecyclerView,
        rootView: View
    ) {
        try {
            when (value) {
                "0811", "0812", "0813", "0821", "0822", "0823", "0852", "0853" -> {
                    GlideUtils.glideCircle(context, IMG_TELKOMSEL, imageView)
                    PrefUtils.saveImageName(context, IMG_TELKOMSEL)
                    imageView.visibility = View.VISIBLE
                    recyclerView.visibility = View.VISIBLE
                }


                "0856", "0857", "0855", "0814", "0815", "0816" -> {
                    GlideUtils.glideCircle(context, IMG_INDOSAT, imageView)
                    PrefUtils.saveImageName(context, IMG_INDOSAT)

                    imageView.visibility = View.VISIBLE
                    recyclerView.visibility = View.VISIBLE
                }
                "0818", "0819", "0859", "0817", "0877", "0878" -> {
                    GlideUtils.glideCircle(context, IMG_XL, imageView)
                    PrefUtils.saveImageName(context, IMG_XL)

                    imageView.visibility = View.VISIBLE
                    recyclerView.visibility = View.VISIBLE
                }

                "0838", "0831", "0832" -> {
                    GlideUtils.glideCircle(context, IMG_AXIS, imageView)
                    PrefUtils.saveImageName(context, IMG_AXIS)

                    imageView.visibility = View.VISIBLE
                    recyclerView.visibility = View.VISIBLE
                }
                "0896", "0897", "0899", "0898" -> {
                    GlideUtils.glideCircle(context, IMG_THREE, imageView)
                    PrefUtils.saveImageName(context, IMG_THREE)

                    imageView.visibility = View.VISIBLE
                    recyclerView.visibility = View.VISIBLE
                }
                "0881", "0882", "0883", "0884", "0887", "0888", "0889" -> {
                    GlideUtils.glideCircle(context, IMG_THREE, imageView)
                    PrefUtils.saveImageName(context, IMG_THREE)
                    imageView.visibility = View.VISIBLE
                    recyclerView.visibility = View.VISIBLE
                }
                else -> {
                    SnackBarUtils.showSnackBar(rootView, "Nomor tidak dikenal")
                    imageView.visibility = View.INVISIBLE
                    recyclerView.visibility = View.INVISIBLE
                }
            }
        } catch (e: Exception) {
            e.message
        }
    }

}



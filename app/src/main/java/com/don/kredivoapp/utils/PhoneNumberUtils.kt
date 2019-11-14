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
                    GlideUtils.glideCircle(context, "img_telkomsel", imageView)
                    imageView.visibility = View.VISIBLE
                    recyclerView.visibility = View.VISIBLE
                }


                "0856", "0857", "0855", "0814", "0815", "0816" -> {
                    GlideUtils.glideCircle(context, "img_indosat", imageView)
                    imageView.visibility = View.VISIBLE
                    recyclerView.visibility = View.VISIBLE
                }
                "0818", "0819", "0859", "0817", "0877", "0878" -> {
                    GlideUtils.glideCircle(context, "img_xl", imageView)
                    imageView.visibility = View.VISIBLE
                    recyclerView.visibility = View.VISIBLE
                }

                "0838", "0831", "0832" -> {
                    GlideUtils.glideCircle(context, "img_axis", imageView)
                    imageView.visibility = View.VISIBLE
                    recyclerView.visibility = View.VISIBLE
                }
                "0896", "0897", "0899", "0898" -> {
                    GlideUtils.glideCircle(context, "img_three", imageView)
                    imageView.visibility = View.VISIBLE
                    recyclerView.visibility = View.VISIBLE
                }
                "0881", "0882", "0883", "0884", "0887", "0888", "0889" -> {
                    GlideUtils.glideCircle(context, "img_three", imageView)
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



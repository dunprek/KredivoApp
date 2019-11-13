package com.don.kredivoapp.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.don.kredivoapp.R

/**
 * Created by gideon on 14,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
object PhoneNumberUtils {
    const val TELKOMSEL = "telkomsel"
    const val INDOSAT = "indosat"
    const val XL = "xl"
    const val AXIS = "axis"
    const val THREE = "three"
    const val SMARTFREN = "smartfren"
    const val NONE = "none"


    fun checkPhoneNumber(
        context: Context,
        value: String,
        imageView: ImageView,
        recyclerView: RecyclerView
    ) {
        try {
            when (value) {
                "0811", "0812", "0813", "0821", "0822", "0823", "0852", "0853" ->
                    updateView(context, TELKOMSEL, imageView, recyclerView)
                "0856", "0857", "0855", "0814", "0815", "0816" ->
                    updateView(context, INDOSAT, imageView, recyclerView)
                "0818", "0819", "0859", "0817", "0877", "0878" ->
                    updateView(context, XL, imageView, recyclerView)
                "0838", "0831", "0832" ->
                    updateView(context, AXIS, imageView, recyclerView)
                "0896", "0897", "0899", "0898" ->
                    updateView(context, THREE, imageView, recyclerView)
                "0881", "0882", "0883", "0884", "0887", "0888", "0889" ->
                    updateView(context, SMARTFREN, imageView, recyclerView)
                else ->
                    updateView(context, NONE, imageView, recyclerView)
            }
        } catch (e: Exception) {
            e.message
        }
    }

    private fun updateView(
        context: Context,
        provider: String,
        imageView: ImageView,
        recyclerView: RecyclerView
    ) {
        when (provider) {
            TELKOMSEL ->
                setImages(
                    imageView,
                    recyclerView,
                    context.getDrawable(R.drawable.img_telkomsel)
                )
            INDOSAT ->
                setImages(
                    imageView,
                    recyclerView,
                    context.getDrawable(R.drawable.img_indosat)
                )
            XL ->
                setImages(
                    imageView,
                    recyclerView,
                    context.getDrawable(R.drawable.img_xl)
                )
            AXIS ->
                setImages(
                    imageView,
                    recyclerView,
                    context.getDrawable(R.drawable.img_axis)
                )
            THREE ->
                setImages(
                    imageView,
                    recyclerView,
                    context.getDrawable(R.drawable.img_three)
                )
            SMARTFREN ->
                setImages(
                    imageView,
                    recyclerView,
                    context.getDrawable(R.drawable.img_smartfren)
                )
            NONE -> unknown(imageView,recyclerView)
        }
    }

    private fun setImages(imageView: ImageView, recyclerView: RecyclerView, drawable: Drawable?) {
        imageView.setImageDrawable(drawable)
        recyclerView.visibility = View.VISIBLE
    }


    private fun unknown(imageView: ImageView, recyclerView: RecyclerView) {
        print("Nomor tidak dikenal")
        imageView.visibility = View.GONE
        recyclerView.visibility = View.GONE
    }


}



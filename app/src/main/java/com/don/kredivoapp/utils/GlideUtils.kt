package com.don.kredivoapp.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.don.kredivoapp.R

/**
 * Created by gideon on 13,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */

object GlideUtils {
    fun glideWithPlaceHolder(context: Context, url: String?, iv: ImageView) {
        val requestOptions = RequestOptions()
        val options =
            requestOptions
                .placeholder(R.mipmap.ic_launcher)
                .transforms(FitCenter(), RoundedCorners(4))

        try {
            Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv)
        } catch (e: Exception) {
            Glide.with(context)
                .load(R.mipmap.ic_launcher)
                .into(iv)
        }

    }

    fun glideCircle(context: Context, imageName: String?, iv: ImageView) {
        val requestOptions = RequestOptions()
        val options =
            requestOptions.circleCrop().fitCenter()

        try {
            Glide.with(context)
                .load(
                    context.resources
                        .getIdentifier(
                            imageName,
                            "drawable",
                            context.packageName)
                )
                .apply(options)
                .into(iv)
        } catch (e: Exception) {
            Glide.with(context)
                .load(R.mipmap.ic_launcher)
                .into(iv)
        }

    }
}
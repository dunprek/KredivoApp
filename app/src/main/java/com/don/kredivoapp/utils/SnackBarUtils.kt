package com.don.kredivoapp.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar


/**
 * Created by gideon on 19,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
object SnackBarUtils {
    fun showSnackBar(rootView: View, mMessage: String) {
        Snackbar.make(rootView, mMessage, Snackbar.LENGTH_SHORT)
            .show()
    }
}
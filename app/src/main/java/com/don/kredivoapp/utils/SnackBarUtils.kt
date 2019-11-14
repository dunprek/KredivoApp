package com.don.kredivoapp.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService



/**
 * Created by gideon on 14,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
object SnackBarUtils {
    fun showSnackBar(rootView: View, mMessage: String) {
        Snackbar.make(rootView, mMessage, Snackbar.LENGTH_SHORT)
            .show()
    }
}
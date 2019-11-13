package com.don.kredivoapp.base

import android.content.DialogInterface
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.don.kredivoapp.R

/**
 * Created by gideon on 13,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
abstract class BaseActivity : AppCompatActivity() {
    fun showBackArrow() {
        val toolbar = supportActionBar
        if (toolbar != null) {
            toolbar.setDisplayHomeAsUpEnabled(true)
        } else {
            showErrorAlert("Toolbar is not set")
        }
    }

    fun hideBackArrow() {
        val toolbar = supportActionBar
        if (toolbar != null) {
            toolbar.setDisplayHomeAsUpEnabled(false)
        } else {
            showErrorAlert("Toolbar is not set")
        }
    }


    //base activity
    fun setToolbarTitle(title: String) {
        val toolbar = supportActionBar
        if (toolbar != null) {
            toolbar.title = title

        } else {
            showErrorAlert("Toolbar is not set")
        }
    }


    fun setToolbarTitle(
        tvTitle: TextView,
        tvSubTitle: TextView,
        title: String,
        subTitle: String
    ) {
        val toolbar = supportActionBar
        if (toolbar != null) {

            tvTitle.text = title
            tvSubTitle.text = subTitle

        } else {
            showErrorAlert("Toolbar is not set")
        }
    }
    fun showErrorAlert(message: String) {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle(R.string.alert_title)
            .setMessage(message)
            .setPositiveButton(R.string.alert_close, DialogInterface.OnClickListener { dialog, which ->
                if (message.contains("404")) {
//                        logout()
                } else {
                    dialog.dismiss()
                }
            })
            .create()
        alertDialog.show()

        //set dialog button color
        //get color
        val buttonColor = resources.getColor(R.color.colorAccent)
        //get the positive button
        val pbutton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
        //set the color to the buttton
        pbutton.setTextColor(buttonColor)
    }

}
package com.don.kredivoapp.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.provider.ContactsContract
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.don.kredivoapp.R
import com.don.kredivoapp.ui.topup.TopUpActivity
import com.don.kredivoapp.utils.PhoneNumberUtils.checkPhoneNumber
import com.google.android.material.snackbar.Snackbar

/**
 * Created by gideon on 20,November,2019
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
            .setPositiveButton(
                R.string.alert_close,
                DialogInterface.OnClickListener { dialog, which ->
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

    fun showSnackBar(string: String) {
        Snackbar.make(findViewById(android.R.id.content), string, Snackbar.LENGTH_LONG)
            .show();
    }

    fun runThread(context: Context) {
        val background = object : Thread() {
            override fun run() {

                try {
                    // Thread will sleep for 3 seconds
                    Thread.sleep((2 * 1000).toLong())


                    val intent = Intent(context, TopUpActivity::class.java)
                    startActivity(intent)
                    //Remove activity
                    finish()

                } catch (e: Exception) {

                }

            }
        }

        // start thread
        background.start()
    }




}
package com.don.kredivoapp.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

/**
 * Created by gideon on 16,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class PrefUtils {

    companion object {
        lateinit var sharedPreferences: SharedPreferences
        private const val PREF_NAME = "KREDIVO_PREF"
        private const val PREF_IMAGE_NAME = "image_name"
        private const val PREF_PHONE_NUMBER = "phone_number"


        fun saveImageName(context: Context, printerName: String) {
           val editor = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit()
            editor.putString(PREF_IMAGE_NAME, printerName)
                .apply()
        }

        fun getImageName(context: Context): String? {
            sharedPreferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
            return sharedPreferences.getString(PREF_IMAGE_NAME, "")
        }

        fun savePhoneNumber(context: Context, phoneNumber: String) {
            val editor = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit()
            editor.putString(PREF_PHONE_NUMBER, phoneNumber)
                .apply()
        }

        fun getPhoneNumber(context: Context): String? {
            sharedPreferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
            return sharedPreferences.getString(PREF_PHONE_NUMBER, "")
        }
    }


}
package com.don.kredivoapp.base

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.don.kredivoapp.utils.PhoneNumberUtils
import com.don.kredivoapp.utils.PrefUtils
import kotlinx.android.synthetic.main.fragment_data_package.*
import kotlinx.android.synthetic.main.fragment_pulsa.*

/**
 * Created by gideon on 20,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
abstract class BaseFragment : Fragment() {

    companion object {
        private const val RESULT_PICK_CONTACT_PULSA = 1
        private const val RESULT_PICK_CONTACT_DATA = 2
    }


    fun hideSoftKeyboard() {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            // Check for the request code, we might be usign multiple startActivityForResult
            when (requestCode) {
                RESULT_PICK_CONTACT_PULSA ->
                    contactPulsaPicked(data!!)
                RESULT_PICK_CONTACT_DATA ->
                    contactDataPick(data!!)
            }
        } else {
            Log.e("PulsaFragment", "Failed to pick contact")
        }
    }

    fun getContactPulsa() {
        val contactPickerIntent = Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        )
        startActivityForResult(contactPickerIntent, RESULT_PICK_CONTACT_PULSA)
    }

    fun getContactData() {
        val contactPickerIntent = Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        )
        startActivityForResult(contactPickerIntent, RESULT_PICK_CONTACT_DATA)
    }

    @SuppressLint("Recycle")
    private fun contactPulsaPicked(data: Intent) {

        val cursor: Cursor?
        var phoneNo: String

        try {
//            val name: String
            // getData() method will have the Content Uri of the selected contact
            val uri = data.data
            //Query the content uri
            cursor = this.activity?.contentResolver?.query(uri!!, null, null, null, null)
            cursor!!.moveToFirst()
            // column index of the phone number
            val phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            // column index of the contact name
//            val nameIndex =
//                cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            phoneNo = cursor.getString(phoneIndex)
//            name = cursor.getString(nameIndex)
            // Set the value to the textviews

            phoneNo = phoneNo.replace("+62", "0")
            phoneNo = phoneNo.replace("-", "")
            phoneNo = phoneNo.replace(" ", "")


            tv_mobile_number.text = phoneNo

            PrefUtils.savePhoneNumber(context!!, phoneNo)

            iv_close.visibility = View.VISIBLE
            phoneNo = phoneNo.substring(0, Math.min(phoneNo.length, 4))
            PhoneNumberUtils.checkPhoneNumber(
                context!!,
                phoneNo,
                iv_pulsa,
                rv_pulsa,
                cl_pulsa
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @SuppressLint("Recycle")
    private fun contactDataPick(data: Intent) {

        val cursor: Cursor?
        var phoneNo: String

        try {
//            val name: String
            // getData() method will have the Content Uri of the selected contact
            val uri = data.data
            //Query the content uri
            cursor = this.activity?.contentResolver?.query(uri!!, null, null, null, null)
            cursor!!.moveToFirst()
            // column index of the phone number
            val phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            // column index of the contact name
//            val nameIndex =
//                cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            phoneNo = cursor.getString(phoneIndex)
//            name = cursor.getString(nameIndex)
            // Set the value to the textviews

            phoneNo = phoneNo.replace("+62", "0")
            phoneNo = phoneNo.replace("-", "")
            phoneNo = phoneNo.replace(" ", "")


            tv_mobile_data.text = phoneNo
            PrefUtils.savePhoneNumber(context!!, phoneNo)
            iv_close_data.visibility = View.VISIBLE
            phoneNo = phoneNo.substring(0, Math.min(phoneNo.length, 4))
            PhoneNumberUtils.checkPhoneNumber(
                context!!,
                phoneNo,
                iv_data_package,
                rv_data_package,
                constraint_data
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
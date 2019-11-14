package com.don.kredivoapp.ui.topup.pulsa


import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.don.kredivoapp.R
import com.don.kredivoapp.base.BaseFragment
import com.don.kredivoapp.data.PromoEntity
import com.don.kredivoapp.data.TopUpEntity
import com.don.kredivoapp.ui.promo.PromoActivity
import com.don.kredivoapp.utils.PhoneNumberUtils.checkPhoneNumber
import kotlinx.android.synthetic.main.fragment_pulsa.*


/**
 * A simple [Fragment] subclass.
 */
class PulsaFragment : BaseFragment(), PromoAdapter.OnClickItem, PulsaAdapter.OnClickItem {
    private lateinit var promoAdapter: PromoAdapter
    private lateinit var pulsaAdapter: PulsaAdapter
    private lateinit var viewModel: PulsaViewModel
    private lateinit var listPromos: ArrayList<PromoEntity>
    private lateinit var listTopUp: ArrayList<TopUpEntity>
    private val RESULT_PICK_CONTACT = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pulsa, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PulsaViewModel::class.java)
        setupPulsa()
        setupPromo()
        tv_mobile_number.setOnClickListener {
            showEditText(context!!)
        }
        iv_close.setOnClickListener {
            tv_mobile_number.text = ""
            iv_close.visibility = View.INVISIBLE
            rv_pulsa.visibility = View.INVISIBLE
            iv_pulsa.visibility = View.INVISIBLE
        }

        btn_contact.setOnClickListener {
            getAllContact()
        }
    }

    private fun setupPromo() {
        listPromos = viewModel.getPromos()
        promoAdapter = PromoAdapter(listPromos, activity!!, this)
        rv_promo.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_promo)
        rv_promo.setHasFixedSize(true)
        rv_promo.adapter = promoAdapter
    }

    private fun setupPulsa() {
        listTopUp = viewModel.getPulsas()
        pulsaAdapter = PulsaAdapter(listTopUp, activity!!, this)
        rv_pulsa.layoutManager = LinearLayoutManager(context)
        rv_pulsa.setHasFixedSize(true)
        rv_pulsa.adapter = pulsaAdapter
    }

    override fun onClickView(item: PromoEntity) {
        val intent = Intent(activity, PromoActivity::class.java)
        intent.putExtra(
            PromoActivity.EXTRA_ID,
            item.id
        )
        startActivity(intent)
    }


    override fun onClickView(item: TopUpEntity) {
    }

    private fun showEditText(context: Context) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) //before
        dialog.setContentView(R.layout.dialog_edit_text)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()

        val etPhoneNumber = dialog.findViewById(R.id.et_phone_number) as EditText
        etPhoneNumber.setText(tv_mobile_number.text.toString().trim())
        etPhoneNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                val etValue = etPhoneNumber.text.toString().trim()
                if (etValue.length >= 4) {
                    try {
                        val firstFourDigits = etValue.substring(0, Math.min(etValue.length, 4))
                        //check phone number based on prefix
                        checkPhoneNumber(
                            context,
                            firstFourDigits,
                            iv_pulsa,
                            rv_pulsa,
                            constraint_pulsa
                        )
//                        Log.d(TAG, firstFourDigits)
                    } catch (e: Exception) {
                    }
                }
                tv_mobile_number.text = etPhoneNumber.text.toString().trim()
                if (etValue.length >= 1) {
                    iv_close.visibility = View.VISIBLE
                } else {
                    iv_close.visibility = View.INVISIBLE
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
        val btnOk = dialog.findViewById(R.id.btn_ok) as Button
        btnOk.setOnClickListener {
            hideSoftKeyboard()
            dialog.hide()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            // Check for the request code, we might be usign multiple startActivityForReslut
            when (requestCode) {
                RESULT_PICK_CONTACT -> contactPicked(data!!)
            }
        } else {
            Log.e("MainActivity", "Failed to pick contact")
        }
    }

    private fun getAllContact() {
        val contactPickerIntent = Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        )
        startActivityForResult(contactPickerIntent, RESULT_PICK_CONTACT)
    }

    @SuppressLint("Recycle")
    private fun contactPicked(data: Intent): String {
        var cursor: Cursor? = null
        var phoneNo: String = ""

        try {
            var name: String? = null
            // getData() method will have the Content Uri of the selected contact
            val uri = data.data
            //Query the content uri
            cursor = this.activity?.contentResolver?.query(uri!!, null, null, null, null)
            cursor!!.moveToFirst()
            // column index of the phone number
            val phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            // column index of the contact name
            val nameIndex =
                cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            phoneNo = cursor.getString(phoneIndex)
            name = cursor.getString(nameIndex)
            // Set the value to the textviews

            phoneNo = phoneNo!!.replace("+62", "0")
            phoneNo = phoneNo.replace("-", "")
            phoneNo = phoneNo.replace(" ", "")
            tv_mobile_number.text = phoneNo
            iv_close.visibility = View.VISIBLE
            phoneNo = phoneNo.substring(0, Math.min(phoneNo.length, 4))
            checkPhoneNumber(
                context!!,
                phoneNo,
                iv_pulsa,
                rv_pulsa,
                constraint_pulsa
            )
        } catch (e: Exception) {
            e.printStackTrace()
            phoneNo = ""
        }
        return phoneNo
    }
}

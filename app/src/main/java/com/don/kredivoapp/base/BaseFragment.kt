package com.don.kredivoapp.base

import android.content.Context
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * Created by gideon on 14,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
abstract class BaseFragment : Fragment() {
    fun hideSoftKeyboard() {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
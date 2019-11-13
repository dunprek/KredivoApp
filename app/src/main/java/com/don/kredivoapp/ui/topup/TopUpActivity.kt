package com.don.kredivoapp.ui.topup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.don.kredivoapp.R
import com.don.kredivoapp.ui.topup.datapackage.DataPackageFragment
import com.don.kredivoapp.ui.topup.pulsa.PulsaFragment
import com.google.android.material.tabs.TabLayout

class TopUpActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_up)
        tabLayout = findViewById(R.id.tabs_example)
        viewPager = findViewById(R.id.viewpager_example)
        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PulsaFragment(), getString(R.string.label_title_pulsa))
        adapter.addFragment(DataPackageFragment(), getString(R.string.label_title_data_package))
        viewPager.adapter = adapter
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList.get(position)
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList.get(position)
        }
    }

}

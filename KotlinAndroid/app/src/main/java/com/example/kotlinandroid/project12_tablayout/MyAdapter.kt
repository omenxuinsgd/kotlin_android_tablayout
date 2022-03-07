package com.example.kotlinandroid.project12_tablayout

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                return FirstFragmentFramelayout()
            }
            1 -> {
                return FirstFragmentViewpager()
            }
            2 -> {
                // val movieFragment = MovieFragment()
                return SecondFragmentViewpager()
            }
            else -> return SecondFragmentFramelayout()
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}
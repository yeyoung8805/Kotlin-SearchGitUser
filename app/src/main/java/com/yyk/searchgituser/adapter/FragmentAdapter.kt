package com.yyk.searchgituser.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yyk.searchgituser.ui.StarFragment
import com.yyk.searchgituser.ui.MyFragment
import com.yyk.searchgituser.ui.SearchFragment

class FragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        val fragment = when(position) {
            0->SearchFragment()
            1->StarFragment()
            2->MyFragment()
            else->SearchFragment()
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val title = when(position) {
            0->"Search"
            1->"Star"
            2->"My"
            else->"Search"
        }
        return title
    }


}
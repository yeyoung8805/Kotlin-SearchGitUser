package com.yyk.searchgituser.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yyk.searchgituser.ui.MyFragment
import com.yyk.searchgituser.ui.SearchFragment
import com.yyk.searchgituser.ui.DatabaseFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val fragmentList = listOf(
        SearchFragment(),
        DatabaseFragment(),
        MyFragment()
    )

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }


}
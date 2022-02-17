package com.yyk.searchgituser.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.yyk.searchgituser.adapter.ViewPagerAdapter
import com.yyk.searchgituser.databinding.BottomNavBinding
import com.yyk.searchgituser.databinding.FragmentStartBinding

class StartFragment: Fragment() {
    private lateinit var startFragmentBinding: FragmentStartBinding
    private lateinit var bottomNavBinding: BottomNavBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bottomNavBinding = BottomNavBinding.inflate(inflater, container, false)
        startFragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        return startFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = startFragmentBinding.viewPager
        val tabLayout = startFragmentBinding.tabLayout
        val relativeLayoutList = listOf(
            bottomNavBinding.btnBottomNaviSearch,
            bottomNavBinding.btnBottomNaviDatabase,
            bottomNavBinding.btnBottomNaviMy
        )
        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) {
            tab: TabLayout.Tab,
            i: Int -> tab.customView = relativeLayoutList[i]
        }.attach()
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })
    }
}
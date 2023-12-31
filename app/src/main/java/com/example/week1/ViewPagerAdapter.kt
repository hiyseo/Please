package com.example.week1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.week1.ui.contact.ContactFragment
import com.example.week1.ui.images.ImageFragment
import com.example.week1.ui.topic3.Topic3Fragment

class ViewPagerAdapter (fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ContactFragment()
            1 -> ImageFragment()
            else -> Topic3Fragment()
        }
    }
}
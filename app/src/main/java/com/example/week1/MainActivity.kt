package com.example.week1

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.week1.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val tabTextList = listOf("연락처","갤러리","날씨")
    private val tabIconList = listOf(R.drawable.baseline_account_box_24, R.drawable.baseline_auto_awesome_mosaic_24, R.drawable.baseline_cloud_24)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        navController = findNavController(R.id.pager)

        binding.pager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.navView, binding.pager) { tab, pos ->
            tab.text = tabTextList[pos]
            tab.setIcon(tabIconList[pos])
        }.attach()
    }
}
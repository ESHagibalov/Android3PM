package com.example.glomadovbottomnavigation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.glomadovbottomnavigation.databinding.ActivityMainBinding
import com.example.glomadovbottomnavigation.ui.events.EventsFragment
import com.example.glomadovbottomnavigation.ui.holidays.HolidaysFragment
import com.example.glomadovbottomnavigation.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setupBottomNavigationBar()
        setContentView(binding.root)
        setupNavigation(binding)

//        binding.botNav.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.navigation_events -> {
//                  //  Log.e("NOW", binding.containerView.findNavController().currentDestination?.id.toStrin)
//                    binding.containerView.findNavController().navigate(R.id.action_fragment_home_to_fragment_events)
//                    true
//                }
//                R.id.navigation_holidays -> {
//                    openFragment(HolidaysFragment())
//                    true
//                }
//                R.id.navigation_profile -> {
//                    openFragment(HomeFragment())
//                    true
//                }
//                else -> true
//            }
//        }
    }

    private fun setupNavigation(binding: ActivityMainBinding) {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.containerView) as NavHostFragment?

        NavigationUI.setupWithNavController(
            binding.botNav, navHostFragment!!.navController
        )

    }

    private fun setupBottomNavigationBar() {
        binding.botNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_events -> {
                 //   findNavController().navigate(R.id.action_fragment_home_to_fragment_events)
                    true
                }
                R.id.navigation_holidays -> {
                    openFragment(HolidaysFragment())
                    true
                }
                R.id.navigation_profile -> {
                    openFragment(HomeFragment())
                    true
                }
                else -> true
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerView, fragment)
            .addToBackStack(null)
            .commit()
    }
}
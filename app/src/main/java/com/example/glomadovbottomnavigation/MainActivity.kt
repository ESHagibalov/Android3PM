package com.example.glomadovbottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.glomadovbottomnavigation.databinding.ActivityMainBinding
import com.example.glomadovbottomnavigation.ui.events.EventsFragment
import com.example.glomadovbottomnavigation.ui.holidays.HolidaysFragment
import com.example.glomadovbottomnavigation.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setupBottomNavigationBar()
        setContentView(binding.root)
    }

    private fun setupBottomNavigationBar() {
        binding.botNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_events -> {
                    openFragment(EventsFragment())
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
            .replace(R.id.fragment_home, fragment)
            .addToBackStack(null)
            .commit()
    }
}
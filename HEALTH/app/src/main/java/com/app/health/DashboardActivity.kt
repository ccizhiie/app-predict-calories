package com.app.health

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationDashboard)

        // Default fragment
        loadFragment(HomeFragment())

        // Handle navigation item clicks
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_search -> loadFragment(SearchFragment())
                R.id.nav_favorite -> loadFragment(FavoriteFragment())
                R.id.nav_settings -> loadFragment(SettingsFragment())
                R.id.nav_profile -> loadFragment(ProfileFragment())

            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_dashboard, fragment)
            .commit()
    }
}

package com.app.health

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.app.health.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Data untuk onboarding
        val onboardingItems = listOf(
            OnboardingItem(
                R.drawable.image1,
                "Lacak Kesehatan Anda",
                "Pantau perkembangan kesehatan \nAnda dengan mudah. Catat berat \nbadan, tinggi badan, dan asupan \nkalori untuk memulai \nperjalanan sehat Anda."
            ),
            OnboardingItem(
                R.drawable.image2,
                "Hitung BMR Anda",
                "Hitung kebutuhan kalori harian (BMR) \nberdasarkan berat badan, tinggi \nbadan, dan usia Anda untuk \nmenjaga energi \nseimbang sepanjang hari."
            ),
            OnboardingItem(
                R.drawable.image3,
                "Rekomendasi Makanan",
                "Dapatkan rekomendasi makanan \nsehat yang sesuai dengan \nkebutuhan kalori dan gaya hidup \nAnda, untuk membantu mencapai \ntujuan kesehatan Anda."
            )
        )

        // Mengatur adapter untuk ViewPager2
        val adapter = ViewPagerAdapter(onboardingItems)
        binding.viewPager.adapter = adapter

        // Dots indicator setup
        binding.dotsIndicator.attachTo(binding.viewPager)

        // Page change listener
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == onboardingItems.lastIndex) {
                    binding.textSkip.visibility = View.GONE
                    binding.buttonStart.visibility = View.VISIBLE
                } else {
                    binding.textSkip.visibility = View.VISIBLE
                    binding.buttonStart.visibility = View.GONE
                }
            }
        })

        // Skip button listener
        binding.textSkip.setOnClickListener {
            binding.viewPager.currentItem = onboardingItems.lastIndex
        }

//         Start button listener
        binding.buttonStart.setOnClickListener {
            // Navigasi ke halaman utama aplikasi
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
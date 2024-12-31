package com.app.health

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.health.databinding.FragmentHomeBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.utils.ColorTemplate

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Daftar gambar
        val imageList = listOf(
            ImageItem(R.drawable.image1),
            ImageItem(R.drawable.image2),
            ImageItem(R.drawable.image3),
        )

        // Inisialisasi adapter
        val imagePagerAdapter = ImagePagerAdapter(imageList)
        binding.foodViewPager.adapter = imagePagerAdapter

        // Sambungkan DotsIndicator ke ViewPager2
        binding.dotsIndicator.setViewPager2(binding.foodViewPager)



        // Update ProgressBar dan TextView untuk nilai protein, lemak, dan karbohidrat
        binding.proteinProgress.progress = 100
        binding.proteinValue.text = "78/90g"

        binding.fatsProgress.progress = 45
        binding.fatsValue.text = "45/70g"

        binding.carbsProgress.progress = 95
        binding.carbsValue.text = "95/110g"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

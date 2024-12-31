package com.app.health

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Tambahkan click listener untuk "Prediksi Kalori Kamu"
        val predictionLayout = view.findViewById<LinearLayout>(R.id.predict_calory)
        predictionLayout.setOnClickListener {
            val intent = Intent(activity, ActivityCalory::class.java)
            startActivity(intent)
        }

        val editProfileLayout = view.findViewById<LinearLayout>(R.id.edit)
        editProfileLayout.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}

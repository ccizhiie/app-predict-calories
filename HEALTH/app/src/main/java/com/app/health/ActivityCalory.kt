package com.app.health

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ActivityCalory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calory)

        val backButton: ImageView = findViewById(R.id.btn_back_profile)
        // Tombol Back
        backButton.setOnClickListener {
            // Kembali ke aktivitas sebelumnya
            onBackPressed()
        }
    }
}

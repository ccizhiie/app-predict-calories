package com.app.health

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Ini digunakan untuk menyembunyikan status bar dan menjadikan splash screen layar penuh.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Gunakan Handler untuk menunda eksekusi dan menampilkan MainActivity setelah beberapa detik
        Handler(Looper.getMainLooper()).postDelayed({
            try {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                e.printStackTrace()  // Tambahkan pengecekan jika ada kesalahan
            }
        }, 3000) // 3000 ms = 3 detik
    }
}


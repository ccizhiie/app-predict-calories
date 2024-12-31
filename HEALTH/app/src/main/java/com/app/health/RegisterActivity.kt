package com.app.health

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.app.health.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ubah sebagian teks dengan warna
        val fullText = "Sudah Punya Akun? Login"
        val spannable = SpannableString(fullText)

        // Cari posisi teks "Login"
        val startIndex = fullText.indexOf("Login")
        val endIndex = startIndex + "Login".length

        // Warna hijau untuk "Login"
        val color = ContextCompat.getColor(this, R.color.green)
        spannable.setSpan(
            ForegroundColorSpan(color),
            startIndex,
            endIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // Tetapkan ke TextView
        binding.textLogin.text = spannable

        // Set listener untuk navigate ke halaman login
        binding.textLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}

package com.app.health

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.app.health.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ubah sebagian teks dengan warna
        val fullText = "Belum Punya Akun? Register"
        val spannable = SpannableString(fullText)

        // Cari posisi teks "Register"
        val startIndex = fullText.indexOf("Register")
        val endIndex = startIndex + "Register".length

        // Warna hijau untuk "Register"
        val color = ContextCompat.getColor(this, R.color.green)
        spannable.setSpan(
            ForegroundColorSpan(color),
            startIndex,
            endIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // Tetapkan ke TextView
        binding.textRegister.text = spannable

        // Set listener untuk navigate ke halaman register
        binding.textRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.buttonLogin.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish() // Menutup LoginActivity agar tidak bisa kembali ke login
            } else {
                Toast.makeText(this, "Isi semua kolom terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

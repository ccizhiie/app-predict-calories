package com.app.health

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // Referensi View
        val backButton: ImageView = findViewById(R.id.btn_back_profile)
        val editPictureButton: ImageView = findViewById(R.id.btn_edit_picture)
        val nameField: EditText = findViewById(R.id.et_name)
        val emailField: EditText = findViewById(R.id.et_email)
        val passwordField: EditText = findViewById(R.id.et_password)
        val saveButton: Button = findViewById(R.id.btn_save)

        // Tombol Back
        backButton.setOnClickListener {
            onBackPressed()
        }

        // Tombol Edit Foto
        editPictureButton.setOnClickListener {
            Toast.makeText(this, "Edit foto diimplementasikan nanti", Toast.LENGTH_SHORT).show()
        }

        // Tombol Simpan
        saveButton.setOnClickListener {
            val name = nameField.text.toString()
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            // Validasi data (contoh sederhana)
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
                // Simpan data atau kirim ke server
            }
        }
    }
}


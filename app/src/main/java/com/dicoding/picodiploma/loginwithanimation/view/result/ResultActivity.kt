package com.dicoding.picodiploma.loginwithanimation.view.result

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.picodiploma.loginwithanimation.R
import com.dicoding.picodiploma.loginwithanimation.databinding.ActivityResultBinding
import com.dicoding.picodiploma.loginwithanimation.view.main.MainActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tangkap data dari MainActivity
        val userName = intent.getStringExtra("USER_NAME")

        // Tampilkan hasil berdasarkan input nama
        displayResult(userName)

        // Tombol untuk kembali mencari
        binding.btnRetry.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun displayResult(userName: String?) {
        when (userName?.lowercase()) {
            "nurul" -> {
                binding.tvResultTitle.text = "Khodam: Komodo Coklat"
                binding.ivResultImage.setImageResource(R.drawable.newww) // Gambar untuk Nurul
            }
            "irfandhy" -> {
                binding.tvResultTitle.text = "Khodam: Dinosaurus"
                binding.ivResultImage.setImageResource(R.drawable.dinasaur) // Gambar untuk Irfandhy
            }
            else -> {
                binding.tvResultTitle.text = "Nama tidak ditemukan"
                binding.ivResultImage.setImageResource(R.drawable.not) // Gambar default
            }
        }
    }
}

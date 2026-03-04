package com.example.latihanterbimbing

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.latihanterbimbing.R

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvHasilPesan = findViewById<TextView>(R.id.tvHasilPesan)

        // Ambil data dari intent
        val pesanDiterima = intent.getStringExtra("EXTRA_PESAN")
        tvHasilPesan.text = pesanDiterima

        // Kirim data balik (balasan)
        val etBalasan = findViewById<EditText>(R.id.etBalasan)
        val btnBalas = findViewById<Button>(R.id.btnBalas)

        btnBalas.setOnClickListener {
            val balasan = etBalasan.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("EXTRA_BALASAN", balasan)

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
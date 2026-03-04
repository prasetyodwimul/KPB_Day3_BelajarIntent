package com.example.latihanterbimbing

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.latihanterbimbing.R
import com.example.latihanterbimbing.SecondActivity
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {

    // 1. Daftarkan Launcher untuk menangkap hasil
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val dataBalasan = result.data?.getStringExtra("EXTRA_BALASAN")
            Toast.makeText(this, "Balasan: $dataBalasan", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPesan = findViewById<EditText>(R.id.etPesan)
        val btnKirim = findViewById<Button>(R.id.btnKirim)

        btnKirim.setOnClickListener {
            val pesan = etPesan.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("EXTRA_PESAN", pesan)

            // 2. Gunakan launcher (bukan startActivity)
            resultLauncher.launch(intent)
        }
    }
}
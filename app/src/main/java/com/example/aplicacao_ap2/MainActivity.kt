package com.example.aplicacao_ap2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext = findViewById<Button>(R.id.Button)
        btnNext.setOnClickListener {
            val intent = Intent(this@MainActivity, PrimeiraQuestao ::class.java)
            startActivity(intent)
           }
       }
}
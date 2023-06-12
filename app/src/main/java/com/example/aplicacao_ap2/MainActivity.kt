package com.example.aplicacao_ap2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    private lateinit var seu_nome : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seu_nome = findViewById(R.id.seu_nome)

        val btnNext = findViewById<Button>(R.id.Button)
        btnNext.setOnClickListener {

            val nome = seu_nome.text.toString()

            val intent = Intent(this@MainActivity, PrimeiraQuestao ::class.java)

            intent.putExtra("nome", nome)

            startActivity(intent)
           }
       }
}
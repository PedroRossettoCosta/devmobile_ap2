package com.example.aplicacao_ap2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TerceiraQuestao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terceira_questao)

        val btnNext = findViewById<Button>(R.id.Q3)
        btnNext.setOnClickListener {
            val intent = Intent(this@TerceiraQuestao, Resultado ::class.java)
            startActivity(intent)
        }
    }
}

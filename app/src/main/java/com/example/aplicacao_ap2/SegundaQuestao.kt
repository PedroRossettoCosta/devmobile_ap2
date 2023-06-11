package com.example.aplicacao_ap2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import com.example.aplicacao_ap2.PrimeiraQuestao

class SegundaQuestao : AppCompatActivity() {

    private lateinit var Barratam: RatingBar
    private lateinit var Barragol: RatingBar
    private lateinit var Barraazul: RatingBar
    private lateinit var Barrapassa: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_questao)

        val notaTam1 = intent.getFloatExtra("BarraTam", 0.0f)
        val notaGol1 = intent.getFloatExtra("BarraGol", 0.0f)
        val notaAzul1 = intent.getFloatExtra("BarraAzul", 0.0f)
        val notaPassa1 = intent.getFloatExtra("BarraPassa", 0.0f)

        Barratam = findViewById(R.id.Barratam)
        Barragol = findViewById(R.id.Barragol)
        Barraazul = findViewById(R.id.Barraazul)
        Barrapassa = findViewById(R.id.Barrapassa)

        var notaTam2= 0.0f
        var notaGol2 = 0.0f
        var notaAzul2 = 0.0f
        var notaPassa2 = 0.0f

        Barratam.setOnRatingBarChangeListener { _, rating, _ ->
            notaTam2 = rating
        }

        Barragol.setOnRatingBarChangeListener { _, rating, _ ->
           notaGol2 = rating
        }

        Barraazul.setOnRatingBarChangeListener { _, rating, _ ->
            notaAzul2 = rating
        }

        Barrapassa.setOnRatingBarChangeListener { _, rating, _ ->
            notaPassa2 = rating
        }

        val btnNext = findViewById<Button>(R.id.Q2)
        btnNext.setOnClickListener {

            val valortam = notaTam1 + notaTam2
            val valorgol = notaGol1 + notaGol2
            val valorazul = notaAzul1 + notaAzul2
            val valorpassa = notaPassa1 + notaPassa2

            val message = "Ratings: Tam=$valortam, Gol=$valorgol, Azul=$valorazul, Passa=$valorpassa"
            Toast.makeText(this@SegundaQuestao, message, Toast.LENGTH_SHORT).show()

            val intent = Intent(this@SegundaQuestao, TerceiraQuestao ::class.java)
            startActivity(intent)
        }
    }
    }

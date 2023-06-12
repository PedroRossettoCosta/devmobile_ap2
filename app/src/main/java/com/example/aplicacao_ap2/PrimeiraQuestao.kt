package com.example.aplicacao_ap2


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import com.example.aplicacao_ap2.PrimeiraQuestao

class PrimeiraQuestao : AppCompatActivity() {

    private lateinit var BarraTam: RatingBar
    private lateinit var BarraGol: RatingBar
    private lateinit var BarraAzul: RatingBar
    private lateinit var BarraPassa: RatingBar

    private var nome: String? = null

    private var notaTam: Float = 0.0f
    private var notaGol: Float = 0.0f
    private var notaAzul: Float = 0.0f
    private var notaPassa: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeira_questao)

        nome = intent.getStringExtra("nome")

        BarraTam = findViewById(R.id.Barratam)
        BarraGol = findViewById(R.id.Barragol)
        BarraAzul = findViewById(R.id.Barraazul)
        BarraPassa = findViewById(R.id.Barrapassa)

        BarraTam.setOnRatingBarChangeListener { _, rating, _ ->
            notaTam = rating
        }

        BarraGol.setOnRatingBarChangeListener { _, rating, _ ->
            notaGol = rating
        }

        BarraAzul.setOnRatingBarChangeListener { _, rating, _ ->
            notaAzul = rating
        }

        BarraPassa.setOnRatingBarChangeListener { _, rating, _ ->
            notaPassa = rating
        }



        val btnNext = findViewById<Button>(R.id.Q1)
        btnNext.setOnClickListener {

            val message = "Ratings: Tam=$notaTam, Gol=$notaGol, Azul=$notaAzul, Passa=$notaPassa"
            Toast.makeText(this@PrimeiraQuestao, message, Toast.LENGTH_SHORT).show()

            val intent = Intent(this@PrimeiraQuestao, SegundaQuestao::class.java)

            intent.putExtra("BarraTam", notaTam)
            intent.putExtra("BarraGol", notaGol)
            intent.putExtra("BarraAzul", notaAzul)
            intent.putExtra("BarraPassa", notaPassa)

            intent.putExtra("nome", nome)

            startActivity(intent)
        }
    }
}
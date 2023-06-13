package com.example.aplicacao_ap2


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import com.example.aplicacao_ap2.SegundaQuestao

class TerceiraQuestao : AppCompatActivity() {

    private lateinit var BarraTam: RatingBar
    private lateinit var BarraGol: RatingBar
    private lateinit var BarraAzul: RatingBar
    private lateinit var BarraPassa: RatingBar

    private var nome: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terceira_questao)

        nome = intent.getStringExtra("nome")

        val notaTam3 = intent.getFloatExtra("BarraTam2", 0.0f)
        val notaGol3 = intent.getFloatExtra("BarraGol2", 0.0f)
        val notaAzul3 = intent.getFloatExtra("BarraAzul2", 0.0f)
        val notaPassa3 = intent.getFloatExtra("BarraPassa2", 0.0f)

        BarraTam = findViewById(R.id.Barratam)
        BarraGol = findViewById(R.id.Barragol)
        BarraAzul = findViewById(R.id.Barraazul)
        BarraPassa = findViewById(R.id.Barrapassa)

        var notaTam4= 0.0f
        var notaGol4 = 0.0f
        var notaAzul4 = 0.0f
        var notaPassa4 = 0.0f

        BarraTam.setOnRatingBarChangeListener { _, rating, _ ->
            notaTam4 = rating
        }

        BarraGol.setOnRatingBarChangeListener { _, rating, _ ->
            notaGol4 = rating
        }

        BarraAzul.setOnRatingBarChangeListener { _, rating, _ ->
            notaAzul4 = rating
        }

        BarraPassa.setOnRatingBarChangeListener { _, rating, _ ->
            notaPassa4 = rating
        }

        val btnNext = findViewById<Button>(R.id.Q3)
        btnNext.setOnClickListener {

            val valortotaltam = notaTam3 + notaTam4
            val valortotalgol = notaGol3 + notaGol4
            val valortotalazul = notaAzul3 + notaAzul4
            val valortotalpassa = notaPassa3 + notaPassa4

            val message = "Ratings: Tam=$valortotaltam, Gol=$valortotalgol, Azul=$valortotalazul, Passa=$valortotalpassa"
            Toast.makeText(this@TerceiraQuestao, message, Toast.LENGTH_SHORT).show()

            val intent = Intent(this@TerceiraQuestao, Resultado ::class.java)

            intent.putExtra("valortotaltam", valortotaltam)
            intent.putExtra("valortotalgol", valortotalgol)
            intent.putExtra("valortotalazul", valortotalazul)
            intent.putExtra("valortotalpassa", valortotalpassa)

            intent.putExtra("nome", nome)

            startActivity(intent)
        }
    }

    fun resetQuiz() {
        nome = null
        // Reset rating bar values to initial state
        BarraTam.rating = 0.0f
        BarraGol.rating = 0.0f
        BarraAzul.rating = 0.0f
        BarraPassa.rating = 0.0f
    }


}

package com.example.aplicacao_ap2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Resultado : AppCompatActivity() {

    private lateinit var textViewTam: TextView
    private lateinit var textViewGol: TextView
    private lateinit var textViewAzul: TextView
    private lateinit var textViewPassa: TextView

    private lateinit var imageViewtam: ImageView
    private lateinit var imageViewgol: ImageView
    private lateinit var imageViewazul: ImageView
    private lateinit var imageViewpassa: ImageView

    private lateinit var botaoResultado: Button

    private var nome : String? = null

    data class Resultado(val valor: Float, val acao: () -> Unit)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        nome = intent.getStringExtra("nome")

        textViewTam = findViewById(R.id.textViewTam)
        textViewGol = findViewById(R.id.textViewGol)
        textViewAzul = findViewById(R.id.textViewAzul)
        textViewPassa = findViewById(R.id.textViewPassaredo)

        imageViewtam = findViewById(R.id.imageViewtam)
        imageViewgol = findViewById(R.id.imageViewgol)
        imageViewazul = findViewById(R.id.imageViewazul)
        imageViewpassa = findViewById(R.id.imageViewpassa)

        botaoResultado = findViewById(R.id.botaoResultado)



        val valorfinaltam = intent.getFloatExtra("valortotaltam", 0.0f)
        val valorfinalgol = intent.getFloatExtra("valortotalgol", 0.0f)
        val valorfinalazul = intent.getFloatExtra("valortotalazul", 0.0f)
        val valorfinalpassa = intent.getFloatExtra("valortotalpassa", 0.0f)

        Log.d("Valores", "Tam: $valorfinaltam, Gol: $valorfinalgol, Azul: $valorfinalazul, Passaredo: $valorfinalpassa")

        val resultados = listOf(
            Resultado(valorfinaltam) {
                textViewTam.visibility = View.VISIBLE
                textViewTam.text = "A empresa favorita de $nome é a Tam!"
                imageViewtam.visibility = View.VISIBLE
                botaoResultado.visibility = View.VISIBLE

                botaoResultado.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("https://www.latamairlines.com/br/pt/ofertas/promocoes-latam?origin=all&destination=all&gad=1&gclid=CjwKCAjw4ZWkBhA4EiwAVJXwqRS_9NyG7z-k7mZEVhVbQx9QcqJ_RInvqATfQFleWXX2rWosY09UnxoC34MQAvD_BwE&gclsrc=aw.ds")
                    startActivity(intent)
                }
            },
            Resultado(valorfinalgol) {
                textViewGol.visibility = View.VISIBLE
                textViewGol.text = "A empresa favorita de $nome é a Gol!"
                imageViewgol.visibility = View.VISIBLE
                botaoResultado.visibility = View.VISIBLE

                botaoResultado.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("https://www.voegol.com.br/?gclid=CjwKCAjw4ZWkBhA4EiwAVJXwqVzssDVSkTifU5TJBrCAw9mHLMzIbFg0AwPqHmanep3ayL9ytwxkJRoCITMQAvD_BwE&gclsrc=aw.ds")
                    startActivity(intent)
                }
            },
            Resultado(valorfinalazul) {
                textViewAzul.visibility = View.VISIBLE
                textViewAzul.text = "A empresa favorita de $nome é a Azul!"
                imageViewazul.visibility = View.VISIBLE
                botaoResultado.visibility = View.VISIBLE

                botaoResultado.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("https://www.voeazul.com.br/br/pt/home")
                    startActivity(intent)
                }
            },
            Resultado(valorfinalpassa) {
                textViewPassa.visibility = View.VISIBLE
                textViewPassa.text = "A empresa favorita de $nome é a Passaredo!"
                imageViewpassa.visibility = View.VISIBLE
                botaoResultado.visibility = View.VISIBLE

                botaoResultado.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("https://www.voepass.com.br/empresa/site/")
                    startActivity(intent)
                }
            }
        )


        val maxResultado = resultados.maxByOrNull { it.valor }


        maxResultado?.acao?.invoke()

        }
    }


package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fuelcalculator.databinding.ActivityMainConsumoCarroBinding
import com.google.android.material.snackbar.Snackbar

class Mainconsumocarro : AppCompatActivity() {

    private lateinit var binding: ActivityMainConsumoCarroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainConsumoCarroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVoltar.setOnClickListener {
            val intent = Intent(this, Mainvlrcombustivel::class.java)
            startActivity(intent)
        }

        binding.btnProximo.setOnClickListener {
            val vlrConsumoCarTemp = binding.tieConsumo.text

            if (vlrConsumoCarTemp?.isEmpty() == true) {
                Snackbar.make(
                    binding.tieConsumo, "Preencha o consumo", Snackbar.LENGTH_SHORT
                ).show()
            } else {

                val vlrConsumoCar: Int = vlrConsumoCarTemp.toString().toInt()
                val vlrCombustivel = intent.getFloatExtra("vlrCombustivel", 0.0f)

                val intent = Intent(this, Maindistancia::class.java)
                intent.apply {
                    putExtra("vlrCombustivel", vlrCombustivel)
                    putExtra("vlrConsumo", vlrConsumoCar)
                }

                startActivity(intent)
            }


        }


    }
}
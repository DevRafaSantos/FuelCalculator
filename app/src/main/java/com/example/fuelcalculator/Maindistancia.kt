package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fuelcalculator.databinding.ActivityMainDistanciaBinding
import com.google.android.material.snackbar.Snackbar

class Maindistancia : AppCompatActivity() {

    private lateinit var binding: ActivityMainDistanciaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainDistanciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVoltar.setOnClickListener {
            val intent = Intent(this, Mainconsumocarro::class.java)
            startActivity(intent)
        }

        binding.btnProximo.setOnClickListener {
            val DistanciaTemp = binding.tieDistancia.text

            if (DistanciaTemp?.isEmpty() == true) {
                Snackbar.make(
                    binding.tieDistancia, "Preencha a distância", Snackbar.LENGTH_SHORT
                ).show()
            } else {

                val vlrDistancia: Float = DistanciaTemp.toString().toFloat()
                val vlrCombustivel = intent.getFloatExtra("vlrCombustivel", 0.0f)
                val vlrConsumoCar = intent.getIntExtra("vlrConsumo",0)


                val intent = Intent(this, Mainresult::class.java)
                intent.apply {
                    putExtra("vlrDistancia", vlrDistancia)
                    putExtra("vlrCombustivel", vlrCombustivel)
                    putExtra("vlrConsumo", vlrConsumoCar)
                }
                startActivity(intent)
            }


        }

    }
}
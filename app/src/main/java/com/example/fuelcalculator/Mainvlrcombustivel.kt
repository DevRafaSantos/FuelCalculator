package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fuelcalculator.databinding.ActivityMainVlrCombustivelBinding
import com.google.android.material.snackbar.Snackbar

class Mainvlrcombustivel : AppCompatActivity() {

    private lateinit var binding: ActivityMainVlrCombustivelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainVlrCombustivelBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnProximo.setOnClickListener {
            val vlrCombustivelTemp = binding.tieCombustivel.text

            if (vlrCombustivelTemp?.isEmpty() == true) {
                Snackbar.make(
                    binding.tieCombustivel,
                    "Preencha o valor do combustível",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {

                val vlrCombustivel: Float = vlrCombustivelTemp.toString().toFloat()

                val intent = Intent(this, Mainconsumocarro::class.java)
                intent.apply {
                    putExtra("vlrCombustivel", vlrCombustivel)
                }

                startActivity(intent)

            }

        }

    }
}
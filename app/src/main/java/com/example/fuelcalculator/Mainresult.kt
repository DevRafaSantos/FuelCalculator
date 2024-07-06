package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fuelcalculator.databinding.ActivityMainResultBinding
import java.text.NumberFormat
import java.util.Locale

class Mainresult : AppCompatActivity() {

    private lateinit var binding: ActivityMainResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vlrCombustivel = intent.getFloatExtra("vlrCombustivel", 0.0f)
        val vlrConsumoCar = intent.getIntExtra("vlrConsumo", 0)
        val vlrDistancia = intent.getFloatExtra("vlrDistancia",0.0f)

        binding.tvVlrCombustivel.text = vlrCombustivel.toString()
        binding.tvVlrConsumo.text = vlrConsumoCar.toString() + " km/l"
        binding.tvVlrKm.text = vlrDistancia.toString()

        val resultadoTemp = (vlrDistancia / vlrConsumoCar) * vlrCombustivel
        val formMoeda: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt","BR"))
        val resultado: String = formMoeda.format(resultadoTemp)

        binding.tvResult.text = resultado


        binding.btnRefazer.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }
}
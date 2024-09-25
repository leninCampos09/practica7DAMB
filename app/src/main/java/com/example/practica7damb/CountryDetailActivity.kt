package com.example.practica7damb

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CountryDetailActivity : AppCompatActivity() {

    private lateinit var countryNameTextView: TextView
    private lateinit var countryFlagImageView: ImageView
    private lateinit var countryHistoryTextView: TextView // Añadido para la historia

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_country_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        countryFlagImageView = findViewById(R.id.countryFlagImageView)
        countryNameTextView = findViewById(R.id.textViewCountryName)
        countryHistoryTextView = findViewById(R.id.textViewCountryHistory) // Inicializa el TextView de historia

        // Captura los datos del Intent
        val name = intent.getStringExtra("COUNTRY_NAME")
        val flag = intent.getIntExtra("COUNTRY_FLAG", 0)
        val history = intent.getStringExtra("COUNTRY_HISTORY") // Captura la historia

        // Establecer el nombre, la bandera y la historia en las vistas
        countryNameTextView.text = name
        countryFlagImageView.setImageResource(flag) // Establecer la imagen de la bandera
        countryHistoryTextView.text = history // Establecer la historia en el TextView
    }
}

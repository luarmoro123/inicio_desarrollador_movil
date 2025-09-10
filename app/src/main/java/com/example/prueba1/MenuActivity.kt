package com.example.prueba1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnSaludar = findViewById<AppCompatButton>(R.id.SaludarAdd)
        val btnTelefono = findViewById<AppCompatButton>(R.id.TelefonoAdd)
        val btnCalculadora = findViewById<AppCompatButton>(R.id.CalculadoraAdd)
        fun navigateToSaludarApp(){
            val saludarAdd = Intent(this, MainActivity::class.java)
            startActivity(saludarAdd)
        }
        fun navigateToTelefonoApp(){
            val calcularAdd = Intent(this, TelefonoActivity::class.java)
            startActivity(calcularAdd)
        }
        fun navigateToCalculadoraApp(){
            val calcularAdd = Intent(this, CalculadoraActivity::class.java)
            startActivity(calcularAdd)
        }

        btnSaludar.setOnClickListener { navigateToSaludarApp() }
        btnTelefono.setOnClickListener { navigateToTelefonoApp() }
        btnCalculadora.setOnClickListener { navigateToCalculadoraApp() }







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
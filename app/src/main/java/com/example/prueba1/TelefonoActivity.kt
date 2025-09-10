package com.example.prueba1

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import android.Manifest
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.ImageButton


class TelefonoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_telefono)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnEliminar = findViewById<Button>(R.id.btnEliminar)
        val btnllamar = findViewById<Button>(R.id.btnllamar)
        val btnllamar_logo = findViewById<ImageButton>(R.id.btnllamar_logo)
        val btnEliminar_logo = findViewById<ImageButton>(R.id.btnEliminar_logo)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btn0 = findViewById<Button>(R.id.btn0)


        btn1.setOnClickListener { tvResultado.text = tvResultado.text.toString() + "1" }
        btn2.setOnClickListener { tvResultado.text = tvResultado.text.toString() + "2" }
        btn3.setOnClickListener { tvResultado.text = tvResultado.text.toString() + "3" }
        btn4.setOnClickListener { tvResultado.text = tvResultado.text.toString() + "4" }
        btn5.setOnClickListener { tvResultado.text = tvResultado.text.toString() + "5" }
        btn6.setOnClickListener { tvResultado.text = tvResultado.text.toString() + "6" }
        btn7.setOnClickListener { tvResultado.text = tvResultado.text.toString() + "7" }
        btn8.setOnClickListener { tvResultado.text = tvResultado.text.toString() + "8" }
        btn9.setOnClickListener { tvResultado.text = tvResultado.text.toString() + "9" }
        btn0.setOnClickListener { tvResultado.text = tvResultado.text.toString() + "0" }
        btnEliminar.setOnClickListener {
            tvResultado.text = tvResultado.text.dropLast(1)
        }
        btnEliminar_logo.setOnClickListener {
            tvResultado.text = tvResultado.text.dropLast(1)
        }

        fun realizarLlamada(numero: String) {
            val uri = Uri.parse("tel:$numero")
            startActivity(Intent(Intent.ACTION_CALL, uri))
        }

        val pedirPermisoLlamada = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { concedido ->
            if (concedido) {
                // Si el permiso fue concedido, vuelve a llamar con el número guardado
                realizarLlamada(tvResultado.text.toString())
            } else {
                Toast.makeText(this, "Permiso de llamada denegado", Toast.LENGTH_SHORT).show()
            }
        }

        fun llamar(numero: String) {
            val tienePermiso = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED
            if (tienePermiso) {
                realizarLlamada(numero)
            } else {
                pedirPermisoLlamada.launch(Manifest.permission.CALL_PHONE)
            }
        }
        btnllamar.setOnClickListener {
            val numero = tvResultado.text.toString()
            if (numero.isNotEmpty()) {
                llamar(numero)  // 👈 ahora sí se manda el número actual
            } else {
                Toast.makeText(this, getString(R.string.strFaltan), Toast.LENGTH_SHORT).show()
            }
        }
        btnllamar_logo.setOnClickListener{
            val numero = tvResultado.text.toString()
            if (numero.isNotEmpty()) {
                llamar(numero)  // 👈 ahora sí se manda el número actual
            } else {
                Toast.makeText(this, getString(R.string.strFaltan), Toast.LENGTH_SHORT).show()
            }
        }















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
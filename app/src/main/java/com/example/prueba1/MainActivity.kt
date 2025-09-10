package com.example.prueba1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //declaracion de los objetos
        val btnsaludo: Button = findViewById(R.id.btnSaludo)
        val edtSaludo = findViewById<AppCompatEditText>(R.id.edtSaludo)
        val btnLimpiar: Button = findViewById(R.id.btnLimpiar)

        btnsaludo.setOnClickListener {
            var name: String = edtSaludo.text.toString()
            if (name.isNotEmpty()){
                val intent = Intent(this, ResultActiviti::class.java)
                startActivity(intent.putExtra("name",name))

            }
            else{
                Toast.makeText(this, getString(R.string.strFaltan), Toast.LENGTH_SHORT).show()
            }
        }
        btnLimpiar.setOnClickListener {
            edtSaludo.setText("")

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
package com.example.prueba1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.cardview.widget.CardView

class IMCApp : AppCompatActivity() {
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imcapp)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.vieFemale)
    }
    private fun initListeners(){
        viewMale.setOnClickListener {
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            setGenderColor()
        }

    }
    private fun setGenderColor(isMaleSelected: Boolean){
        getBackgroundColor(isMaleSelected)
        getBackgroundColor(isFemaleSelected)
        viewMale.setCardBackgroundColor()
        viewFemale.setCardBackgroundColor()

    }
    private fun getBackgroundColor(isComponentSelected: Boolean){
        val maleBackgroundColor = if(isComponentSelected) Context else R.color.background_component
    }

}
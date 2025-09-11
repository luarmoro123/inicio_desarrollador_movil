package com.example.prueba1

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.support.v4.os.IResultReceiver
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.slider.RangeSlider


class IMCApp : AppCompatActivity() {
    private var isMaleSelected: Boolean = false
    private var isFemaleSelected: Boolean = true

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight : TextView
    private lateinit var rsHeight : RangeSlider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imcapp)
        initComponents()
        initListeners()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.vieFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
    }
    private fun initListeners(){
        viewMale.setOnClickListener {
            if(isMaleSelected){
                setGenderColor()
                changeGender()
            }
        }
        viewFemale.setOnClickListener {
            if(isFemaleSelected) {
                setGenderColor()
                changeGender()
            }
        }
        rsHeight.addOnChangeListener { _,value,_ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }

    }
    private fun changeGender(){
        this.isMaleSelected = !isMaleSelected
        this.isFemaleSelected = !isFemaleSelected
    }
    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))

    }
    private fun getBackgroundColor(isComponentSelected: Boolean):Int{
        val referenColor= if(isComponentSelected) R.color.background_component_selected else R.color.background_component
        return ContextCompat.getColor(this,referenColor)
    }

}
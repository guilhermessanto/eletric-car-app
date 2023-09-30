package com.example.eletric_car_app.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.example.eletric_car_app.R

class MainActivity : AppCompatActivity() {
    lateinit var  btnCalcular: Button
lateinit var lista: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupListeners()
        setupList()
    }
    fun setupView(){
        btnCalcular = findViewById(R.id.btn_calcular)
        lista = findViewById(R.id.lv_informacoes)
    }
    fun setupList(){
        var dados = arrayOf(
            "Cupcake", "Donut","Froyo", "Gingerbread","Honeycoob","Ice Cream Sandwich","Jelly Bean"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,dados)
        lista.adapter = adapter
    }
    fun setupListeners(){
        btnCalcular.setOnClickListener{
            startActivity(Intent(this,CalculaAutonomiaActivity::class.java))
        }
    }

}
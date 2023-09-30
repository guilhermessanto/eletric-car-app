package com.example.eletric_car_app.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.eletric_car_app.R
import com.example.eletric_car_app.data.CarFactory
import com.example.eletric_car_app.ui.Adapter.CarAdapter

class CarFragment : Fragment(){
    lateinit var btnCalcular: Button
    lateinit var listaCarros: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.car_fragment, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupList()
    }
    fun setupView(view : View){
        btnCalcular = view.findViewById(R.id.btn_calcular)
        listaCarros = view.findViewById(R.id.rl_lista_carros)
    }
    fun setupList() {
        val adapter = CarAdapter(CarFactory.list)
        listaCarros.adapter = adapter
    }
    fun setupListeners() {
        btnCalcular.setOnClickListener {
            //startActivity(Intent(this, CalculaAutonomiaActivity::class.java))
        }

    }
}

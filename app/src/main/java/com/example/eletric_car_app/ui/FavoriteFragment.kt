package com.example.eletric_car_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.eletric_car_app.R
import com.example.eletric_car_app.data.local.CarRepository
import com.example.eletric_car_app.domain.Carro
import com.example.eletric_car_app.ui.Adapter.CarAdapter

class FavoriteFragment : Fragment() {
    lateinit var  listaCarrosFavoritos : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorite_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupList()
    }
    private fun getCarsOnLocalDb(): List<Carro>{
        val repository = CarRepository(requireContext())
        val carList = repository.getAll()
        return carList
    }
    fun setupView(view: View) {
        view.apply {
            listaCarrosFavoritos = findViewById(R.id.rl_lista_carros_favoritos)
        }
    }
    fun setupList() {
        val cars = getCarsOnLocalDb()
        val carroAdapter = CarAdapter(cars, isFavoriteScreen = true)
        listaCarrosFavoritos.apply {
            isVisible = true
            adapter = carroAdapter
        }
        carroAdapter.carItemLister = { carro ->
           //val isSaved = CarRepository(requireContext()).saveIfNotExist(carro)
        }
    }
}
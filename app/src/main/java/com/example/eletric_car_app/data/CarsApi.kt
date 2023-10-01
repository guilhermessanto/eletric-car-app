package com.example.eletric_car_app.data

import com.example.eletric_car_app.domain.Carro
import retrofit2.Call
import retrofit2.http.GET

interface CarsApi {
@GET("CarApi")
    fun getAllCars(): Call<List<Carro>>
}
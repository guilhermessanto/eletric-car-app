package com.example.eletric_car_app.data

import com.example.eletric_car_app.domain.Carro

object CarFactory {
    val list = listOf<Carro>(
        Carro(
            id = 1,
            preco = "R$ 300.000,00",
            bateria = "300 Kwh",
            potencia = "200cv",
            recarga = "30 min",
            urlPhoto = "www.google.com.br",
            isFavorite = false

        ),
        Carro(
            id = 2,
            preco = "R$ 200.000,00",
            bateria = "150 Kwh",
            potencia = "150cv",
            recarga = "20 min",
            urlPhoto = "www.google.com.br",
            isFavorite = false

        )
    )
    //Verbos HTTP
    // GET -> Para recuperar informações
    // POST -> Para enviar informaçoes para um servidor
    // DELETE -> Para deletar algum recurso
    // PUT -> Alterar uma entidade como um todo
    // PATCH -> Para alterar um tributo de uma entidade
}

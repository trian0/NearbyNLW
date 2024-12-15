package com.trian0.nearby.data.model.mock

import com.trian0.nearby.data.model.Market
import com.trian0.nearby.data.model.Rule

val mockMarkets = listOf(
    Market(
        id = "1",
        categoryId = "1",
        name = "Sabor Grill",
        description = "Churrascaria com cortes nobres e buffet variado. Experiência completa para os amantes de carne.",
        coupons = 10,
//        rules = listOf(
//            Rule(id = "1", description = "Válido até o dia 25/12", marketId = "1"),
//            Rule(id = "2", description = "Disponível apenas para consumo local", marketId = "1")
//        ),
        latitude = -23.55974230991911,
        longitude = -46.65814845249887,
        address = "Av. Paulista - Bela Vista",
        phone = "(11) 98765-4321",
        cover = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?ixlib=rb-4.0.3"
    ),
    Market(
        id = "2",
        categoryId = "2",
        name = "Sabor Grill",
        description = "Churrascaria com cortes nobres e buffet variado. Experiência completa para os amantes de carne.",
        coupons = 10,
//        rules = emptyList(),
        latitude = -23.55974230991911,
        longitude = -46.65814845249887,
        address = "Av. Paulista - Bela Vista",
        phone = "(11) 98765-4321",
        cover = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?ixlib=rb-4.0.3"
    )
)
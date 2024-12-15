package com.trian0.nearby.ui.screen.home

import com.google.android.gms.maps.model.LatLng
import com.trian0.nearby.data.model.Category
import com.trian0.nearby.data.model.Market

data class HomeUiState(
    val categories: List<Category>? = null,
    val markets: List<Market>? = null,
    val marketLocations: List<LatLng>? = null
)

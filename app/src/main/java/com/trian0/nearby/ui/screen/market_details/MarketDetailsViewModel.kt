package com.trian0.nearby.ui.screen.market_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trian0.nearby.core.network.NearbyRemoteDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MarketDetailsViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(MarketDetailsUiState())
    val uiState: StateFlow<MarketDetailsUiState> = _uiState.asStateFlow()

    fun onEvent(event: MarketDetailsUiEvent) {
        when (event) {
            is MarketDetailsUiEvent.OnFetchRules -> fetchRules(event.marketId)
            is MarketDetailsUiEvent.OnFetchCoupon -> fetchCoupon(event.qrCodeContent)
            is MarketDetailsUiEvent.OnResetCoupon -> resetCoupon()
        }
    }

    private fun fetchCoupon(qrCodeContent: String) {
        viewModelScope.launch {
            NearbyRemoteDataSource.patchCoupon(marketId = qrCodeContent)
                .onSuccess { coupon ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(
                            coupon = coupon.coupon
                        )
                    }
                }
                .onFailure { _ ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(
                            coupon = ""
                        )
                    }
                }
        }
    }

    private fun fetchRules(marketId: String) {
        viewModelScope.launch {
            NearbyRemoteDataSource.getMarketDetails(marketId = marketId)
                .onSuccess { marketDetails ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(
                            rules = marketDetails.rules
                        )
                    }
                }
                .onFailure { _ ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(
                            rules = emptyList()
                        )
                    }
                }
        }
    }

    private fun resetCoupon() {
        _uiState.update { currentUiState ->
            currentUiState.copy(
                coupon = null
            )
        }
    }

}
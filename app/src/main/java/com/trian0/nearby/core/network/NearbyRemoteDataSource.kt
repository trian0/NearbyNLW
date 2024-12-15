package com.trian0.nearby.core.network

import com.trian0.nearby.core.network.KtorHttpClient.httpClientAndroid
import com.trian0.nearby.data.model.Category
import com.trian0.nearby.data.model.Coupon
import com.trian0.nearby.data.model.Market
import com.trian0.nearby.data.model.MarketDetail
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch

object NearbyRemoteDataSource {

    private const val LOCALE_HOST_EMULATOR_BASE_URL = "http://10.0.2.2:3333"
    private const val LOCALE_HOST_PHYSICAL_BASE_URL = "http://192.168.100.70:3333"

    private const val BASE_URL = LOCALE_HOST_PHYSICAL_BASE_URL

    // 1 - busca de categorias
    // 2 - busca de locais (com base em uma categoria)
    // 3 - busca de detalhes de um local (com base em um local especifico)
    // 4 - gerar cupom a partir da leitura do qrcode

    suspend fun getCategories(): Result<List<Category>> = try {
        val categories: List<Category> = httpClientAndroid.get("$BASE_URL/categories").body()

        Result.success(categories)
    } catch (e: Exception) {
        e.printStackTrace()
        Result.failure(e)
    }

    suspend fun getMarkets(categoryId: String): Result<List<Market>> = try {
        val markets: List<Market> =
            httpClientAndroid.get("$BASE_URL/markets/category/${categoryId}").body()

        Result.success(markets)
    } catch (e: Exception) {
        e.printStackTrace()
        Result.failure(e)
    }

    suspend fun getMarketDetails(marketId: String): Result<MarketDetail> = try {
        val marketsDetail: MarketDetail =
            httpClientAndroid.get("$BASE_URL/markets/${marketId}").body()

        Result.success(marketsDetail)
    } catch (e: Exception) {
        e.printStackTrace()
        Result.failure(e)
    }

    suspend fun patchCoupon(marketId: String): Result<Coupon> = try {
        val coupon: Coupon = httpClientAndroid.patch("$BASE_URL/coupons/${marketId}").body()

        Result.success(coupon)
    } catch (e: Exception) {
        e.printStackTrace()
        Result.failure(e)
    }

}
package fuel

interface ApiRates {
    fun getRates(access_key: String): ApiRateResponse?
}

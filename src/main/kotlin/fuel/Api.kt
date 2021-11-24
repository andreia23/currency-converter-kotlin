package fuel

interface Api {

    fun getRates(access_key: String): ApiRateResponse?
}

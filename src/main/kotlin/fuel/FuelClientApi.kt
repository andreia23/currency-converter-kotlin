package fuel

import com.github.kittinunf.fuel.Fuel

object FuelClientApi : Api {

    private val url: String = System.getenv("URL_API") ?: "http://api.exchangeratesapi.io/v1/latest"

    override fun getRates(access_key: String): ApiRateResponse? {

        var apiRateResponse : ApiRateResponse? = null;

//        Fuel.get(url, listOf("access_key" to access_key)).responseObject<ApiRateResponse> {request, response,result ->
//            val (apiResult, fuelError) = result
//
//        }
        return apiRateResponse
    }


}

package fuel

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.Fuel
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class FuelClientApi : ApiRates {

    private val logger: Logger = LoggerFactory.getLogger(FuelClientApi::class.java)

    private val url: String = System.getenv("URL_API")
        ?: "http://api.exchangeratesapi.io/v1/latest"

    override fun getRates(access_key: String): ApiRateResponse? {

        var apiRateResponse: ApiRateResponse? = null

        Fuel.get(url, listOf("access_key" to access_key)).response() { _, _, result ->

            val error = result.component2()

            if (error != null) {
                logger.error("Error to process: ${error.message}")

            } else {
                apiRateResponse = result.component1()?.let {
                    jacksonObjectMapper()
                        .readValue<ApiRateResponse>(it)
                }
            }
        }.get()

        return apiRateResponse

    }
}

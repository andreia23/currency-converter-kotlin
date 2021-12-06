package fuel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import model.resources.Currency
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApiRateResponse(
    val base: Currency,
    val rates: Map<Currency, BigDecimal>
)

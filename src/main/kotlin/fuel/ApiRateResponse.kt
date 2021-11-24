package fuel

import model.resources.Currency
import java.math.BigDecimal

data class ApiRateResponse(
    val base: Currency,
    val rates: Map<Currency, BigDecimal>
)

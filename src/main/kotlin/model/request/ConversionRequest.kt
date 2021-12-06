package model.request

import model.resources.Currency
import java.math.BigDecimal

data class ConversionRequest(
    val sourceCurrency: Currency,
    val sourceValue: BigDecimal,
    val destinationCurrency: Currency,

    )

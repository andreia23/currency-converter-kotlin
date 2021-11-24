package model.dto

import model.resources.Currency
import java.math.BigDecimal
import java.time.Instant

data class ConversionDTO(
    val idTransaction: Long,
    val idUser: Long,
    val sourceCurrency: Currency,
    val sourceValue: BigDecimal,
    val destinationCurrency: Currency,
    val destinationValue: BigDecimal,
    val conversionRate: BigDecimal,
    val date: Instant = Instant.now()

)

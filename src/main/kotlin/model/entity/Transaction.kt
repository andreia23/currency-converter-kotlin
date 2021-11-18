package model.entity

import commons.Currency
import java.math.BigDecimal
import java.time.Instant

data class Transaction(
    val sourceCurrency: Currency,
    val sourceValue: BigDecimal,
    val destinationCurrency: Currency,
    val conversionRate: BigDecimal,
    val date: Instant = Instant.now()
)

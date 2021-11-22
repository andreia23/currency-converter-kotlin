package model.entity

import model.resources.Currency
import java.math.BigDecimal
import java.time.Instant

data class Transaction(
    val sourceCurrency: String,
    val sourceValue: BigDecimal,
    val destinationCurrency: String,
    val conversionRate: BigDecimal,
    val date: Instant = Instant.now()
)

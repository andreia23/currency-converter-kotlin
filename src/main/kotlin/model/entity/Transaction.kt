package model.entity

import java.math.BigDecimal
import java.time.Instant

data class Transaction(
    val sourceCurrency: String,
    val sourceValue: Double,
    val destinationCurrency: String,
    val conversionRate: Double,
    val date: Instant = Instant.now()
)

package model.dto

import java.math.BigDecimal
import java.time.Instant
import java.util.*

data class TransactionDTO(
    val idTransaction: Long,
    val idUser: Long,
    val sourceCurrency: Currency,
    val sourceValue: BigDecimal,
    val destinationCurrency: Currency,
    val conversionRate: BigDecimal,
    val date: Instant = Instant.now()
)

package model.request

import model.resources.Currency
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal

data class ConversionRequest(

    @NotNull("Source currency cannot be null")
    val sourceCurrency: Currency,

    @NotNull("Source value cannot be null")
    val sourceValue: BigDecimal,

    @NotNull("Destination currency cannot be null")
    val destinationCurrency: Currency,

    )

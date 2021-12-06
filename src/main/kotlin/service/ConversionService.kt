package service

import fuel.ApiRateResponse
import fuel.ApiRates
import model.dto.ConversionDTO
import model.entity.Transaction
import model.entity.User
import model.request.ConversionRequest
import model.resources.Currency
import model.resources.repository.TransactionRepository
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

class ConversionService(
    private val transactionRepository: TransactionRepository,
    private val userService: UserService,
    private val apiRates: ApiRates
) {
    fun convertCurrency(idUser: Long, conversionRequest: ConversionRequest): ConversionDTO {

        val user: User? = userService.findOneById(idUser)

        val sourceCurrency: Currency = conversionRequest.sourceCurrency
        val destinationCurrency: Currency = conversionRequest.destinationCurrency
        val sourceValue: BigDecimal = conversionRequest.sourceValue

        var apiRateResponse: ApiRateResponse? = apiRates.getRates("cc1c93359bcca52446be37373d083018")
        val rateSourceCurrency: BigDecimal? = apiRateResponse?.rates?.get(sourceCurrency)
        val rateDestinationCurrency: BigDecimal? = apiRateResponse?.rates?.get(destinationCurrency)
        val finalValue: BigDecimal = calculationToConvert(sourceValue, rateSourceCurrency, rateDestinationCurrency)

        var transaction = Transaction(
            sourceCurrency = sourceCurrency.toString(),
            sourceValue = sourceValue.toDouble(),
            destinationCurrency = destinationCurrency.toString(),
            conversionRate = rateDestinationCurrency?.toDouble() ?: 1.0
        )
        transaction = transactionRepository.insert(transaction)

        return ConversionDTO(
            1, 1, sourceCurrency, sourceValue, destinationCurrency,
            finalValue, rateDestinationCurrency!!
        )

    }

    private fun calculationToConvert(
        sourceValue: BigDecimal, rateSourceCurrency: BigDecimal?,
        rateDestinationCurrency: BigDecimal?
    ): BigDecimal {

        return sourceValue.divide(rateSourceCurrency, 8, RoundingMode.HALF_UP)
            .multiply(rateDestinationCurrency, MathContext(8, RoundingMode.HALF_UP))
    }
}

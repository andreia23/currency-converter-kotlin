package service

import model.entity.User
import model.request.ConversionRequest
import model.resources.repository.TransactionRepository
import java.math.BigDecimal

class ConversionService(
    private val transactionRepository: TransactionRepository,
    private val userService: UserService
) {
    fun convertCurrency(idUser: Long, conversionRequest: ConversionRequest){
        val user: User? = userService.findOneById(idUser)

    }

    fun calculationToConvert(
        sourceValue: BigDecimal, rateSourceCurrency: BigDecimal,
        rateDestinationCurrency: BigDecimal
    ) {

    }
}

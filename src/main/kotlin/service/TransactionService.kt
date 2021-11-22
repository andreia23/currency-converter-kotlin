package service

import model.entity.Transaction
import model.entity.User
import model.resources.repository.TransactionRepository

class TransactionService(
    private val transactionRepository: TransactionRepository,
    private val userService: UserService
) {

    fun saveTransaction(transaction: Transaction): Transaction {
        transactionRepository.insert(transaction)
        return transaction
    }

    fun findAll(): List<Transaction> {
        return transactionRepository.findAll()
    }

    fun transactionsByUser(idUser: Long): List<Transaction>? {
        val user: User? = userService.findOneById(idUser)
        return user?.let {
            transactionRepository.transactionByUser(it) }
    }

}

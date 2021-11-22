package model.resources.repository

import model.entity.Transaction
import model.entity.User

interface TransactionRepository {
    fun transactionByUser(user: User): List<Transaction>
    fun insert(transaction: Transaction): Transaction
    fun findAll(): List<Transaction>
}

package model.resources

import model.entity.Transaction
import model.entity.User
import model.resources.repository.TransactionRepository
import model.resources.schemas.TransactionTable
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class TransactionRepositoryImpl : TransactionRepository {

    override fun transactionByUser(user: User): List<Transaction> {
        TODO("Not yet implemented")
    }

    override fun insert(transaction: Transaction): Transaction {
        return transaction.apply {
            TransactionTable.insert {
                it[sourceCurrency] = transaction.sourceCurrency.toString()
                it[sourceValue] = transaction.sourceValue
                it[destinationCurrency] = transaction.destinationCurrency.toString()
                it[conversionRate] = transaction.conversionRate
            }
        }
    }

    override fun findAll(): List<Transaction> {
        val transactions: List<Transaction> = listOf()

        return transactions.apply {
            TransactionTable.selectAll().map { transactionRow ->
                   val transactions = Transaction(
                       sourceCurrency = transactionRow[TransactionTable.sourceCurrency],
                       sourceValue = transactionRow[TransactionTable.sourceValue],
                       destinationCurrency = transactionRow[TransactionTable.destinationCurrency],
                       conversionRate = transactionRow[TransactionTable.conversionRate]
                   )
            }
        }


    }
}

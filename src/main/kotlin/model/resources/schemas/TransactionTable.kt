package model.resources.schemas

import model.entity.Transaction
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import java.sql.Types.TIMESTAMP

object TransactionTable : Table(name = "transaction") {

    val id = long("id").autoIncrement().primaryKey()

    val sourceCurrency = varchar("sourceCurrency", 3)
    val sourceValue = double("sourceValue")
    val destinationCurrency = varchar("destinationCurrency", 3)
    val conversionRate = double("conversionRate")
    val date = TIMESTAMP
}

fun ResultRow.toTransaction() = Transaction(
    get(TransactionTable.sourceCurrency),
    get(TransactionTable.sourceValue),
    get(TransactionTable.destinationCurrency),
    get(TransactionTable.conversionRate),
)

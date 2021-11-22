package model.resources.schemas

import org.jetbrains.exposed.sql.Table
import java.sql.Types.TIMESTAMP

object TransactionTable : Table(name = "transaction") {

    val id = long("id").autoIncrement().primaryKey()

    val sourceCurrency = varchar("sourceCurrency", 3)
    val sourceValue = decimal("sourceValue", precision = 4, scale = 4)
    val destinationCurrency = varchar("destinationCurrency", 3)
    val conversionRate = decimal("conversionRate", precision = 4, scale = 4)
    val date = TIMESTAMP
}

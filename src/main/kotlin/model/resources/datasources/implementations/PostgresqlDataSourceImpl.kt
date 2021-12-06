package model.resources.datasources.implementations

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import config.EnvironmentConfig
import model.resources.datasources.DataSource
import model.resources.schemas.TransactionTable
import model.resources.schemas.UserTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class PostgresqlDataSourceImpl(private val environmentConfig: EnvironmentConfig) : DataSource {

    lateinit var dataSource: HikariDataSource

    override fun startConnection() {
        dataSource = HikariDataSource(HikariConfig().apply {
            jdbcUrl = environmentConfig.postgresqlJdbcUrl
            username = environmentConfig.postgresqlUsername
            password = environmentConfig.postgresqlPassword
        }).also {
            Database.connect(it)

            transaction {
                SchemaUtils.create(UserTable)
                SchemaUtils.create(TransactionTable)

            }
        }
    }

    override fun stopConnection() = dataSource.close()
}

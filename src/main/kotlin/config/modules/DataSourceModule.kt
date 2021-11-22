package config.modules

import model.resources.datasources.DataSource
import model.resources.datasources.implementations.PostgresqlDataSourceImpl
import org.koin.dsl.module

object DataSourceModule {

    fun modules() = module {
        single { PostgresqlDataSourceImpl(get()) as DataSource }
    }
}

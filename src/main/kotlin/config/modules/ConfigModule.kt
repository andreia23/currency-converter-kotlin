package config.modules

import config.EnvironmentConfig
import org.koin.dsl.module

object ConfigModule {

    fun modules() = module {
        single { EnvironmentConfig() }
    }
}

package config.modules

import org.koin.dsl.module
import routes.ConversionRoutes

object RoutesModule {

    fun modules() = module {
        single { ConversionRoutes(get(), get()) }
    }
}

package config.modules

import fuel.ApiRates
import fuel.FuelClientApi
import org.koin.dsl.module

object FuelModule {

    fun modules() = module {
        single { FuelClientApi() as ApiRates}
        }

}

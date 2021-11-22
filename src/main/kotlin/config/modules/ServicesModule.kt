package config.modules

import org.koin.dsl.module
import service.TransactionService
import service.UserService

object ServicesModule {

    fun modules() = module {
        single { UserService(get()) }
        single { TransactionService(get(), get()) }
//        single { ConversionService(get()) }
    }

}

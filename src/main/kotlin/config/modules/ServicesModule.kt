package config.modules

import model.resources.UserRepositoryImpl
import org.koin.core.scope.get
import org.koin.dsl.module
import service.ConversionService
import service.TransactionService
import service.UserService

object ServicesModule {

    fun modules() = module {
        single { UserService(get()) }
//        single { ConversionService(get()) }
//        single { TransactionService(get()) }
    }

}

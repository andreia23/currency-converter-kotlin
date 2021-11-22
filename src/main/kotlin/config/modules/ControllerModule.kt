package config.modules

import controller.TransactionController
import controller.UserController
import org.koin.dsl.module

object ControllerModule {

    fun modules() = module {
        single { UserController(get()) }
        single { TransactionController(get()) }
    }
}

package config.modules

import controller.UserController
import org.koin.dsl.module

object ControllerModule {

    fun modules() = module {
        single { UserController(get()) }
    }
}

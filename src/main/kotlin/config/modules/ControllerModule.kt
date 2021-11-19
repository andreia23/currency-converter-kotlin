package config.modules

import controller.UserController

object ControllerModule {

    fun modules() = module {
        single { UserController(get()) }
    }
}

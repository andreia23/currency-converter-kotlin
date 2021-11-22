package routes

import controller.ConversionController
import controller.TransactionController
import controller.UserController
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post

class ConversionRoutes(
    private val userController: UserController
//    private val transactionController: TransactionController,
//    private val conversionController: ConversionController
) {
    fun registerRoutes(){
        path("v1/register"){
            post(userController::registerUser)
        }
    }
}

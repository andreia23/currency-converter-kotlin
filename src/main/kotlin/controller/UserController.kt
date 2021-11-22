package controller

import io.javalin.Context
import model.dto.UserDTO
import service.UserService

class UserController(private val userService: UserService) {

    fun registerUser(ctx: Context) {
        ctx.body<UserDTO>()
            .apply {
                ctx.json(userService.saveUser(this.toModel()))
            }
    }
}

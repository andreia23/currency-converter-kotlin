package model.dto

import model.entity.User

data class UserDTO(
    val name: String,
    val lastName: String
) {
    fun toModel(): User = User(userName = name, userLastName = lastName)
}

package service

import model.entity.User
import model.resources.repository.UserRepository

class UserService(
    private val userRepository: UserRepository
) {
    fun saveUser(user: User): User {
        userRepository.insert(user)
        return user
    }
}

package model.resources.repository

import model.entity.User

interface UserRepository {
    fun findOneById(id: Long): User?
    fun insert(user: User): User
}

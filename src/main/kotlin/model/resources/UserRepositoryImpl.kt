package model.resources

import model.entity.User
import model.resources.repository.UserRepository
import model.resources.schemas.UserTable
import model.resources.schemas.toUser
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepositoryImpl : UserRepository {

    override fun findOneById(id: Long): User? {
        return UserTable.select {
            UserTable.id eq id
        }.map {
            it.toUser()
        }.firstOrNull()
    }

    override fun insert(user: User) = transaction {
        user.apply {
            UserTable.insert {
                it[name] = user.userName
                it[lastName] = user.userLastName
            }
        }
    }
}

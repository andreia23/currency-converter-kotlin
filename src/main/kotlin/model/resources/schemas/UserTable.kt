package model.resources.schemas

import model.entity.User
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object UserTable : Table(name = "user") {
    private const val NAME_LENGTH = 40
    private const val LASTNAME_LENGTH = 40

    val id = long("id").autoIncrement().primaryKey()
    val name = varchar("name", NAME_LENGTH)
    val lastName = varchar("lastName", LASTNAME_LENGTH)

}
//procurar outra maneira de fazer isso
fun ResultRow.toUser() = User(
    get(UserTable.name),
    get(UserTable.lastName)
)

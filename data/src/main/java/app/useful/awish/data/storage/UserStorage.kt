package app.useful.awish.data.storage

import app.useful.awish.data.storage.models.User

interface UserStorage {

    fun save(user: User) : Boolean

    fun get() : User
}
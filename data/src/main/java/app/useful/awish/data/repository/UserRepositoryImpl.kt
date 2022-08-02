package app.useful.awish.data.repository

import app.useful.awish.data.storage.models.User
import app.useful.awish.data.storage.UserStorage
import app.useful.awish.domain.models.SaveUserNameParam
import app.useful.awish.domain.models.UserName
import app.useful.awish.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam) : Boolean{
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName() : UserName{
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam) : User{
        return User(saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User) : UserName{
        return UserName(user.firstName, user.lastName)
    }
}
package app.useful.awish.domain.repository

import app.useful.awish.domain.models.SaveUserNameParam
import app.useful.awish.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam) : Boolean

    fun getName() : UserName
}
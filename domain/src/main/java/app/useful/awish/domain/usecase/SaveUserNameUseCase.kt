package app.useful.awish.domain.usecase

import app.useful.awish.domain.models.SaveUserNameParam
import app.useful.awish.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository){

    fun execute(param : SaveUserNameParam) : Boolean{

        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name){
            return false
        }

        val result : Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}
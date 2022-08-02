package app.useful.awish.domain.usecase

import app.useful.awish.domain.models.UserName
import app.useful.awish.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute() : UserName {
        return userRepository.getName()
    }
}
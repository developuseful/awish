package app.useful.awish.di

import app.useful.awish.domain.repository.UserRepository
import app.useful.awish.domain.usecase.GetUserNameUseCase
import app.useful.awish.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository) : GetUserNameUseCase{
        return GetUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository) : SaveUserNameUseCase{
        return SaveUserNameUseCase(userRepository = userRepository)
    }
}


package app.useful.awish.di

import app.useful.awish.data.repository.UserRepositoryImpl
import app.useful.awish.data.storage.UserStorage
import app.useful.awish.data.storage.sharedprefs.SharedPrefUserStorage
import app.useful.awish.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage>{
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository>{
        UserRepositoryImpl(userStorage = get())
    }

}
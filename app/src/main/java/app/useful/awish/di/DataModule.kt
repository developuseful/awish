package app.useful.awish.di

import android.content.Context
import app.useful.awish.data.repository.UserRepositoryImpl
import app.useful.awish.data.storage.UserStorage
import app.useful.awish.data.storage.sharedprefs.SharedPrefUserStorage
import app.useful.awish.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context) : UserStorage{
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage) : UserRepository{
        return UserRepositoryImpl(userStorage = userStorage)

    }
}

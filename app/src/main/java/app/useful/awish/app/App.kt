package app.useful.awish.app

import android.app.Application
import app.useful.awish.di.AppComponent
import app.useful.awish.di.AppModule
import app.useful.awish.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

       appComponent = DaggerAppComponent
           .builder()
           .appModule(AppModule(context = this))
           .build()
    }
}
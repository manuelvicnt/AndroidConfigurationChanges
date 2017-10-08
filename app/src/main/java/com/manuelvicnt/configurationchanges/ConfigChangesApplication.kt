package com.manuelvicnt.configurationchanges

import android.app.Application
import com.manuelvicnt.configurationchanges.dagger.ApplicationComponent
import com.manuelvicnt.configurationchanges.dagger.ApplicationModule
import com.manuelvicnt.configurationchanges.dagger.DaggerApplicationComponent

/**
 * Created by manuelvicnt on 10/8/17.
 */
class ConfigChangesApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}

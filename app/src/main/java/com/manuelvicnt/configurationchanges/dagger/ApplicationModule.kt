package com.manuelvicnt.configurationchanges.dagger

import android.app.Application
import android.content.Context
import com.manuelvicnt.configurationchanges.model.ObjectToInject
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by manuelvicnt on 10/8/17.
 */
@Module
class ApplicationModule(internal var application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context {

        return application
    }

    @Provides
    @Singleton
    fun provideObjectToInject(): ObjectToInject {

        return ObjectToInject("object")
    }
}

package com.manuelvicnt.configurationchanges.dagger

import android.content.Context
import com.manuelvicnt.configurationchanges.model.ObjectToInject
import dagger.Component
import javax.inject.Singleton

/**
 * Created by manuelvicnt on 10/8/17.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun provideContext(): Context
    fun provideObjectToInject(): ObjectToInject
}
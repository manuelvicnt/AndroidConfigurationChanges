package com.manuelvicnt.configurationchanges.newfeature

import com.manuelvicnt.configurationchanges.dagger.FeatureScope
import dagger.Module
import dagger.Provides

/**
 * Created by manuelvicnt on 10/8/17.
 */
@Module
class NewFeatureModule {

    @Provides
    @FeatureScope
    fun provideNewFeatureViewModel(): NewFeatureContract.Actions {
        return NewFeatureViewModel()
    }
}
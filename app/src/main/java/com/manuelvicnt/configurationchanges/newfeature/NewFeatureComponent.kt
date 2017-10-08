package com.manuelvicnt.configurationchanges.newfeature

import com.manuelvicnt.configurationchanges.dagger.ApplicationComponent
import com.manuelvicnt.configurationchanges.dagger.FeatureScope
import dagger.Component

/**
 * Created by manuelvicnt on 10/8/17.
 */
@FeatureScope
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(NewFeatureModule::class))
interface NewFeatureComponent {

    fun inject(fragment: NewFeatureFragment)
}

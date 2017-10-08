package com.manuelvicnt.configurationchanges.dagger

import com.manuelvicnt.configurationchanges.base.BaseActivity
import com.manuelvicnt.configurationchanges.base.BaseFragment
import dagger.Component

/**
 * Created by manuelvicnt on 10/8/17.
 */
@FeatureScope
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface BaseComponent {

    fun inject(fragment: BaseFragment)
    fun inject(activity: BaseActivity)
}

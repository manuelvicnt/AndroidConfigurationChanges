package com.manuelvicnt.configurationchanges.base

import android.os.Bundle
import android.support.annotation.CallSuper
import com.manuelvicnt.configurationchanges.ConfigChangesApplication
import com.manuelvicnt.configurationchanges.configchanges.ComponentCreator
import com.manuelvicnt.configurationchanges.configchanges.ComponentLoader
import com.manuelvicnt.configurationchanges.configchanges.ComponentManagerActivity
import com.manuelvicnt.configurationchanges.dagger.ApplicationComponent
import com.manuelvicnt.configurationchanges.dagger.BaseComponent
import com.manuelvicnt.configurationchanges.dagger.DaggerBaseComponent
import com.manuelvicnt.configurationchanges.model.ObjectToInject
import com.manuelvicnt.configurationchanges.utils.Constants
import javax.inject.Inject

/**
 * Created by manuelvicnt on 10/8/17.
 */
abstract class BaseActivity : ComponentManagerActivity(), ComponentCreator {

    @Inject
    lateinit var objectToInject: ObjectToInject

    abstract val contentView: Int

    protected val applicationComponent: ApplicationComponent
        get() = (application as ConfigChangesApplication).applicationComponent

    private lateinit var baseComponentLoader: ComponentLoader<BaseComponent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createComponents()
        injectDependencies()

        setContentView(contentView)
    }

    override fun createComponent(id: Int): Any? {
        when(id) {
            Constants.COMPONENT_BASE_ID -> {
                DaggerBaseComponent.builder()
                        .applicationComponent(applicationComponent)
                        .build()
            }
        }
        return null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        baseComponentLoader.onSaveInstanceState()
    }

    override fun onResume() {
        super.onResume()
        baseComponentLoader.onResume()
    }

    override fun onDestroy() {
        baseComponentLoader.onDestroy()
        super.onDestroy()
    }

    @CallSuper
    protected fun createComponents() {
        baseComponentLoader = getComponentManager().createComponentLoader(Constants.COMPONENT_BASE_ID, this)
    }

    @CallSuper
    protected fun injectDependencies() {
        baseComponentLoader.component?.inject(this)
    }
}
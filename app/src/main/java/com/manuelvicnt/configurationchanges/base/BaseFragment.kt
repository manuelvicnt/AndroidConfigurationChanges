package com.manuelvicnt.configurationchanges.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import com.manuelvicnt.configurationchanges.ConfigChangesApplication
import com.manuelvicnt.configurationchanges.configchanges.ComponentCreator
import com.manuelvicnt.configurationchanges.configchanges.ComponentLoader
import com.manuelvicnt.configurationchanges.configchanges.ComponentManager
import com.manuelvicnt.configurationchanges.configchanges.ComponentManagerDelegate
import com.manuelvicnt.configurationchanges.dagger.ApplicationComponent
import com.manuelvicnt.configurationchanges.dagger.BaseComponent
import com.manuelvicnt.configurationchanges.model.ObjectToInject
import com.manuelvicnt.configurationchanges.utils.Constants
import javax.inject.Inject

/**
 * Created by manuelvicnt on 10/8/17.
 */
open class BaseFragment : Fragment(), ComponentCreator {

    val applicationComponent: ApplicationComponent
        get() = application.applicationComponent

    val application: ConfigChangesApplication
        get() = activity.application as ConfigChangesApplication

    val componentManager: ComponentManager
        get() = componentManagerDelegate.getComponentManager()

    @Inject
    lateinit var objectToInject: ObjectToInject

    private lateinit var componentManagerDelegate: ComponentManagerDelegate
    private lateinit var baseComponentLoader: ComponentLoader<BaseComponent>
    private lateinit var baseComponentCreator: ComponentCreator

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is ComponentManagerDelegate) {
            componentManagerDelegate = context
        } else {
            throw RuntimeException(javaClass.simpleName + " must be attached to " +
                    "an Activity that implements " + ComponentManagerDelegate::class.java.simpleName)
        }

        if (context is ComponentCreator) {
            baseComponentCreator = context
        } else {
            throw RuntimeException(javaClass.simpleName + " must be attached to " +
                    "an Activity that implements " + ComponentCreator::class.java.simpleName)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createComponents()
        injectDependencies()
    }

    override fun createComponent(id: Int): Any? {
        // The activity will create this component
        return null
    }

    @CallSuper
    open fun createComponents() {
        // This is currently re-using the already created component of the Activity. That's why we do NOT:
        // - track lifecycle events
        // - destroy the cached component since it'll be handled by the activity
        baseComponentLoader = componentManager.createComponentLoader(Constants.COMPONENT_BASE_ID, baseComponentCreator)
    }

    @CallSuper
    open fun injectDependencies() {
        baseComponentLoader.component?.inject(this)
    }
}

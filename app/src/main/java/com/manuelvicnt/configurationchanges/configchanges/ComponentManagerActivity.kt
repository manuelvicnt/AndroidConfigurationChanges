package com.manuelvicnt.configurationchanges.configchanges

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by manuelvicnt on 10/8/17.
 */
open class ComponentManagerActivity : AppCompatActivity(), ComponentManagerDelegate {

    private val componentManager = ComponentManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        componentManager.onCreate(lastCustomNonConfigurationInstance as ComponentCache)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        componentManager.onDestroy()
        super.onDestroy()
    }

    /**
     * Retains the component cache state. DO NOT override this yourself.
     */
    override fun onRetainCustomNonConfigurationInstance(): Any {
        return componentManager.componentCache
    }

    override fun getComponentManager(): ComponentManager {
        return componentManager
    }
}

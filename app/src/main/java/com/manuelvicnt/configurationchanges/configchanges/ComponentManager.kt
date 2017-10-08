package com.manuelvicnt.configurationchanges.configchanges

import android.support.v4.util.ArrayMap

/**
 * Created by manuelvicnt on 10/8/17.
 */
class ComponentManager {

    lateinit var componentCache: ComponentCache
    private var loaders = ArrayMap<Int, ComponentLoader<*>>()

    fun onCreate(lastCustomNonConfigurationInstance: ComponentCache?) {
        if (lastCustomNonConfigurationInstance == null) {
            this.componentCache = ComponentCache()
        } else {
            this.componentCache = lastCustomNonConfigurationInstance
        }
    }

    fun onDestroy() {
        loaders.clear()
    }

    fun <C> createComponentLoader(id: Int, callbacks: ComponentCreator): ComponentLoader<C> {
        var loader: ComponentLoader<C>? = loaders[id] as ComponentLoader<C>?

        if (loader == null) {
            loader = ComponentLoader(componentCache, id, callbacks)
            loaders.put(id, loader)
        }

        return loader
    }
}

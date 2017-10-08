@file:Suppress("UNCHECKED_CAST")

package com.manuelvicnt.configurationchanges.configchanges

/**
 * Created by manuelvicnt on 10/8/17.
 */
class ComponentLoader<C>(private val componentCache: ComponentCache,
                         private val componentId: Int,
                         creator: ComponentCreator) where C : Any? {

    var component: C?
    private var isDestroyedBySystem: Boolean = false

    init {
        component = componentCache.getComponent(componentId) as C

        if (component == null) {
            component = creator.createComponent(componentId) as C
            componentCache.putComponent(componentId, component)
        }
    }

    fun onResume() {
        isDestroyedBySystem = false
    }

    fun onSaveInstanceState() {
        isDestroyedBySystem = true
    }

    fun onDestroy() {
        if (!isDestroyedBySystem) {
            // User is exiting this view, removeComponent component from the componentManager
            componentCache.removeComponent(componentId)
        }
    }
}

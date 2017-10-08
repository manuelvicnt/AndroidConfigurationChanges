package com.manuelvicnt.configurationchanges.configchanges

import android.support.v4.util.ArrayMap

/**
 * Created by manuelvicnt on 10/8/17.
 */
class ComponentCache {

    private val components = ArrayMap<Int, Any>(1)

    fun getComponent(index: Int): Any? {
        return components[index]
    }

    fun removeComponent(index: Int) {
        components.remove(index)
    }

    fun putComponent(index: Int, component: Any?) {
        components.put(index, component)
    }
}
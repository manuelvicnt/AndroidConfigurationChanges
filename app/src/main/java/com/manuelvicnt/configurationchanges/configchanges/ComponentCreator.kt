package com.manuelvicnt.configurationchanges.configchanges

/**
 * Created by manuelvicnt on 10/8/17.
 */
interface ComponentCreator {
    // Creates a new instance of a Component
    fun createComponent(id: Int): Any?
}
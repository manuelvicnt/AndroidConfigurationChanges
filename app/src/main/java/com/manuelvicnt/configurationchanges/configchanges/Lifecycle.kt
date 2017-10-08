package com.manuelvicnt.configurationchanges.configchanges

/**
 * Created by manuelvicnt on 10/8/17.
 */
interface Lifecycle {

    interface View

    interface Actions {

        fun onViewResumed()
        fun onViewAttached(viewCallback: Lifecycle.View)
        fun onViewDetached()
    }
}

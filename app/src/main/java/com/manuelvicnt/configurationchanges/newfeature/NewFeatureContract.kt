package com.manuelvicnt.configurationchanges.newfeature

import com.manuelvicnt.configurationchanges.configchanges.Lifecycle

/**
 * Created by manuelvicnt on 10/8/17.
 */
class NewFeatureContract {

    interface View : Lifecycle.View {
        fun displayTitle(title: String)
    }

    interface Actions : Lifecycle.Actions {
        fun loadData()
    }
}

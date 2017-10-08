package com.manuelvicnt.configurationchanges.newfeature

import com.manuelvicnt.configurationchanges.configchanges.Lifecycle

/**
 * Created by manuelvicnt on 10/8/17.
 */
class NewFeatureViewModel : NewFeatureContract.Actions {

    private var view: NewFeatureContract.View? = null

    override fun onViewResumed() {
        view?.displayTitle("New Feature")
    }

    override fun onViewAttached(viewCallback: Lifecycle.View) {
        this.view = viewCallback as NewFeatureContract.View
    }

    override fun onViewDetached() {
        this.view = null
    }

    override fun loadData() {
        TODO("not implemented")
    }
}

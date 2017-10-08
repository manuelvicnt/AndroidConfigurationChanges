package com.manuelvicnt.configurationchanges.configchanges

/**
 * Created by manuelvicnt on 10/8/17.
 */
class LifecycleAwareFragmentDelegate {

    private var viewModel: Lifecycle.Actions? = null

    fun onViewCreated(viewModel: Lifecycle.Actions) {

        this.viewModel = viewModel
    }

    fun onViewAttached(view: Lifecycle.View) {

        if (viewModel != null) {
            viewModel!!.onViewAttached(view)
        }
    }

    fun onResume() {

        if (viewModel != null) {
            viewModel!!.onViewResumed()
        }
    }

    fun onDetachView() {

        if (viewModel != null) {
            viewModel!!.onViewDetached()
        }
    }
}

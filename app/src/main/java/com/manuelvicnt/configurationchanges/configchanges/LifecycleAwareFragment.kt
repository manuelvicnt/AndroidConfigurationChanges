package com.manuelvicnt.configurationchanges.configchanges

import android.os.Bundle
import android.view.View
import com.manuelvicnt.configurationchanges.base.BaseFragment

/**
 * Created by manuelvicnt on 10/8/17.
 */
abstract class LifecycleAwareFragment : BaseFragment() {

    private val viewModelDelegate = LifecycleAwareFragmentDelegate()

    protected abstract val viewModel: Lifecycle.Actions
    protected abstract val lifecycleView: Lifecycle.View
    protected abstract val componentLoader: ComponentLoader<*>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelDelegate.onViewCreated(viewModel)
    }

    override fun onStart() {
        super.onStart()
        viewModelDelegate.onViewAttached(lifecycleView)
    }

    override fun onResume() {
        super.onResume()
        viewModelDelegate.onResume()
        componentLoader.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        componentLoader.onSaveInstanceState()
    }

    override fun onStop() {
        super.onStop()
        viewModelDelegate.onDetachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        componentLoader.onDestroy()
    }
}
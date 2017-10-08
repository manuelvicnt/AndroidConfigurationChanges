package com.manuelvicnt.configurationchanges.newfeature

import android.os.Bundle
import android.support.annotation.Nullable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.manuelvicnt.configurationchanges.R
import com.manuelvicnt.configurationchanges.configchanges.ComponentLoader
import com.manuelvicnt.configurationchanges.configchanges.LifecycleAwareFragment
import com.manuelvicnt.configurationchanges.utils.Constants
import javax.inject.Inject

/**
 * Created by manuelvicnt on 10/8/17.
 */
class NewFeatureFragment : LifecycleAwareFragment(), NewFeatureContract.View {

    @Inject
    override lateinit var viewModel: NewFeatureContract.Actions

    override val lifecycleView: NewFeatureContract.View
        get() = this

    override val componentLoader: ComponentLoader<NewFeatureComponent>
        get() = newFeatureComponentLoader

    lateinit var newFeatureComponentLoader: ComponentLoader<NewFeatureComponent>
    var titleOnScreen: TextView? = null

    override fun createComponents() {
        super.createComponents()
        newFeatureComponentLoader = componentManager.createComponentLoader(Constants.COMPONENT_NEW_FEATURE_ID, this)
    }

    override fun createComponent(id: Int): Any? {
        when (id) {
            Constants.COMPONENT_NEW_FEATURE_ID -> {
                return DaggerNewFeatureComponent.builder()
                        .applicationComponent(applicationComponent)
                        .build()
            }
        }
        return super.createComponent(id)
    }

    override fun injectDependencies() {
        newFeatureComponentLoader.component?.inject(this)
        super.injectDependencies()
    }

    override fun onCreateView(inflater: LayoutInflater?, @Nullable container: ViewGroup?,
                              @Nullable savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_feature, container, false)

        view?.let {
            it.findViewById<TextView>(R.id.text)?.text = objectToInject.name
            titleOnScreen = it.findViewById<TextView>(R.id.title)
        }

        return view
    }

    override fun displayTitle(title: String) {
        titleOnScreen?.text = title
    }
}

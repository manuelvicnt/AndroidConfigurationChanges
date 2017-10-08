package com.manuelvicnt.configurationchanges.newfeature

import android.os.Bundle
import com.manuelvicnt.configurationchanges.R
import com.manuelvicnt.configurationchanges.base.BaseActivity

/**
 * Created by manuelvicnt on 10/8/17.
 */
class NewFeatureActivity : BaseActivity() {

    override val contentView: Int
        get() = R.layout.activity_feature

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    NewFeatureFragment()).commit()
        }
    }
}
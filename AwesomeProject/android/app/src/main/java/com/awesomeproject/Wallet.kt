package com.awesomeproject

import android.app.Application
import com.facebook.react.PackageList
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.load
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.soloader.SoLoader

open class Wallet(
    private val application: Application,
    private val isNewArchEnabled: Boolean = false,
    private val isHermesEnabled: Boolean = true
) {

    private val mReactNativeHost: ReactNativeHost by lazy {
        object : DefaultReactNativeHost(application) {
            override val isHermesEnabled: Boolean
                get() = this@Wallet.isHermesEnabled

            override val isNewArchEnabled: Boolean
                get() = this@Wallet.isNewArchEnabled

            override fun getUseDeveloperSupport(): Boolean {
                return BuildConfig.DEBUG
            }

            override fun getPackages(): List<ReactPackage> {
                // Packages that cannot be autolinked yet can be added manually here, for example:
                // packages.add(new MyReactNativePackage());
                return PackageList(application).packages
            }

            override fun getJSMainModuleName(): String {
                return "index"
            }
        }
    }

    fun init() {
        SoLoader.init(application,  /* native exopackage */false)
        if (isNewArchEnabled) {
            // If you opted-in for the New Architecture, we load the native entry point for this app.
            load()
        }
        ReactNativeFlipper.initializeFlipper(application, getReactNativeHost().reactInstanceManager)
    }

    fun getReactNativeHost(): ReactNativeHost {
        return mReactNativeHost
    }
}

package com.awesomeproject.sample

import android.app.Application
import com.awesomeproject.Wallet
import com.awesomeproject.WalletApplication

class App : Application(), WalletApplication {

    private val defaultWallet by lazy {
        Wallet(this)
    }

    override fun getWallet(): Wallet = defaultWallet

    override fun onCreate() {
        super.onCreate()
        defaultWallet.init()
    }
}
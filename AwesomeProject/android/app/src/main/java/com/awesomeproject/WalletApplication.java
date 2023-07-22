package com.awesomeproject;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;

public interface WalletApplication extends ReactApplication {

    Wallet getWallet();

    @Override
    default ReactNativeHost getReactNativeHost() {
        return getWallet().getReactNativeHost();
    }
}

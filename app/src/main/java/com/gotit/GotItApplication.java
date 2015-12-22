package com.gotit;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by NguyenHN on 12/21/2015.
 */
public class GotItApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}

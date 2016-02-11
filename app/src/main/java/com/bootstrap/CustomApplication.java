package com.bootstrap;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by msanches on 11/02/16.
 */
public class CustomApplication extends Application {

    private static CustomApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().build());
    }

    public static CustomApplication getApplication() {
        return application;
    }

}

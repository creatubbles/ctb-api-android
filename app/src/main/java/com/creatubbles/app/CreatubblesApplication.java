package com.creatubbles.app;

import android.app.Application;

import com.creatubbles.app.di.components.ApplicationComponent;
import com.creatubbles.app.di.components.DaggerApplicationComponent;
import com.creatubbles.app.di.modules.ApplicationModule;

/**
 * Android Main Application
 */
public class CreatubblesApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}

package com.creatubbles.app.di.components;

import com.creatubbles.app.view.MainActivity;
import com.creatubbles.app.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Janek on 16.02.2016.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

}
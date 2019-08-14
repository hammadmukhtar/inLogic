package com.hammadmukhtar.inlogic.app;

import android.app.Application;

import com.hammadmukhtar.inlogic.api.ApiModule;
import com.hammadmukhtar.inlogic.main.MainModule;
import com.hammadmukhtar.inlogic.preferences.Preferences;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        Preferences.setContext(this);
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .mainModule(new MainModule())
                .apiModule(new ApiModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}

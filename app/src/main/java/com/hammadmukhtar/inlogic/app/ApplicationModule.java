package com.hammadmukhtar.inlogic.app;

import android.app.Application;
import android.content.Context;

import com.hammadmukhtar.inlogic.main.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/* This is where dagger keeps track of the dependencies
* This must be annotated with @Module so dagger knows its a module
* Each feature will have a separate module
* In these modules dagger will look for instance providers and methods */

@Module
public class ApplicationModule {

    private Application application;
    private MainActivity activity;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    public ApplicationModule(Application application, MainActivity activity) {
        this.application = application;
        this.activity = activity;
    }

    @Provides /* For method that will expose available return type */
    @Singleton /* To allow only one instance */
    public Context provideContext(){
        return application;
    }

    @Provides /* For method that will expose available return type */
    @Singleton /* To allow only one instance */
    public MainActivity provideActivity(){
        return activity;
    }
}

package com.hammadmukhtar.inlogic.app;

/* Component where dagger injects dependencies
 * This class is called injector class
 * This component assigns references in our activities, fragments or services
 * Declare all the android components that can be added */

import com.hammadmukhtar.inlogic.api.ApiModule;
import com.hammadmukhtar.inlogic.main.MainActivity;
import com.hammadmukhtar.inlogic.main.MainModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class, MainModule.class })
public interface ApplicationComponent {

    void inject(MainActivity target);
}

package com.hammadmukhtar.inlogic.main;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    public MainActivityMVP.Presenter provideMainActivityPresenter(MainActivityMVP.Model model){
        return new MainActivityPresenter(model);
    }

    @Provides
    public MainActivityMVP.Model provideMainActivityModel(MainRepository respository){
        return new MainModel(respository);
    }

    @Provides
    public MainRepository provideMainRepository(){
        return new CacheRepository();
    }
}

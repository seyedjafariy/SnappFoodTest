package com.worldsnas.snappfoodtest.app;

import com.worldsnas.snappfoodtest.app.db.DataBaseModule;
import com.worldsnas.snappfoodtest.app.network.NetworkModule;
import com.worldsnas.snappfoodtest.app.pref.SharedPrefModule;
import com.worldsnas.snappfoodtest.livedata.SingleLiveData;
import com.worldsnas.snappfoodtest.manager.pref.AppPrefManager;
import com.worldsnas.snappfoodtest.manager.pref.PrefManager;
import com.worldsnas.snappfoodtest.manager.rest.AppRestManager;
import com.worldsnas.snappfoodtest.manager.rest.RestManager;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module(includes = {NetworkModule.class, SharedPrefModule.class, DataBaseModule.class})
abstract class AppModule {

    @Binds
    @Singleton
    abstract PrefManager providePrefManager(AppPrefManager prefManager);

    @Binds
    @Singleton
    abstract RestManager provideRestManager(AppRestManager prefManager);

    @Provides
    static CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    static SingleLiveData<Integer> provideIntegerSingleLiveData(){
        return new SingleLiveData<>();
    }

}

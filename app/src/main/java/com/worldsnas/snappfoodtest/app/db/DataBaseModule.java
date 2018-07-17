package com.worldsnas.snappfoodtest.app.db;

import com.worldsnas.snappfoodtest.app.App;
import com.worldsnas.snappfoodtest.entity.MyObjectBox;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;

@Module
public class DataBaseModule {

    @Provides
    @Singleton
    static BoxStore provideBoxStore(App app){
        return MyObjectBox.builder().androidContext(app).build();
    }
}

package com.worldsnas.snappfoodtest.app;

import com.worldsnas.snappfoodtest.activity.main.MainActivity;
import com.worldsnas.snappfoodtest.activity.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module()
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    public abstract MainActivity bindMainActivity();

}

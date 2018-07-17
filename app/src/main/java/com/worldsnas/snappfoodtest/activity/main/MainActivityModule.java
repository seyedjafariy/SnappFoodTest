package com.worldsnas.snappfoodtest.activity.main;

import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainActivityModule {


//    @Provides
//    static MainActivityViewModel provideViewModel(MainActivity activity, MainActivityViewModelFactory factory){
//        return ViewModelProviders.of(activity, factory).get(MainActivityViewModel.class);
//    }

    @Provides
    static FragmentManager provideFragmentManger(MainActivity activity){
        return activity.getSupportFragmentManager();
    }
}

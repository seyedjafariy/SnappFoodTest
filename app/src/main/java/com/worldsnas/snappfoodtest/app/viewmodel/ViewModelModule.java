package com.worldsnas.snappfoodtest.app.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.worldsnas.snappfoodtest.activity.main.MainActivityViewModel;
import com.worldsnas.snappfoodtest.activity.main.MainViewModelModule;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@SuppressWarnings("unused")
@Module(includes = {MainViewModelModule.class})
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(clazz = MainActivityViewModel.class)
    abstract ViewModel bindMainKViewModel(MainActivityViewModel viewModel);
}

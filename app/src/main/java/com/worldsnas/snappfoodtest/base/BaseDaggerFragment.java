package com.worldsnas.snappfoodtest.base;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.worldsnas.snappfoodtest.app.viewmodel.ViewModelFactory;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.support.DaggerFragment;

public abstract class BaseDaggerFragment<S extends BaseViewState, V extends BaseViewModel<S>> extends DaggerFragment {

    @Inject
    ViewModelFactory mViewModelFactory;
    protected V mViewModel;

    //must be called either in onCreateView or callbacks after that
    public void createViewModel(Class<V> clazz){
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(clazz);
    }

    //must be called after the createViewModel call
    public void startObserving(){
        mViewModel.getStateLD().observe(this, this::handleState);
        mViewModel.getToastLiveData().observe(this, this::showToast);
    }

    public void showToast(String message) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    public void showToast(@StringRes int string) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context.getApplicationContext(), getString(string), Toast.LENGTH_SHORT).show();
        }
    }

    public abstract void handleState(S state);
}

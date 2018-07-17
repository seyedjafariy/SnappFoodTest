package com.worldsnas.snappfoodtest.activity.main;

import android.support.annotation.NonNull;

import com.worldsnas.snappfoodtest.base.BaseViewModel;
import com.worldsnas.snappfoodtest.rxutils.SchedulersFacade;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivityViewModel extends BaseViewModel<MainActivityState> {

    private final MainActivityInteractor mInteractor;

    @Inject
    MainActivityViewModel(@NonNull MainActivityInteractor interactor, @NonNull CompositeDisposable compositeDisposable, @NonNull SchedulersFacade schedulersFacade) {
        super(compositeDisposable, schedulersFacade);
        mInteractor = interactor;
    }
}

package com.worldsnas.snappfoodtest.base;

import com.worldsnas.snappfoodtest.manager.pref.PrefManager;
import com.worldsnas.snappfoodtest.manager.rest.RestManager;
import com.worldsnas.snappfoodtest.rxutils.SchedulersFacade;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BaseInteractor {

    @Inject
    protected PrefManager mPrefManager;
    @Inject
    protected RestManager mRestManager;
    @Inject
    protected SchedulersFacade mSchedulersFacade;
    @Inject
    protected CompositeDisposable mCompositeDisposable;

    public void onClear() {
        mCompositeDisposable.dispose();
        mCompositeDisposable.clear();
    }

}

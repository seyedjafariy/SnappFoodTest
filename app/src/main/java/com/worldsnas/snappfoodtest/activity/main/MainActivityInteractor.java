package com.worldsnas.snappfoodtest.activity.main;

import com.worldsnas.snappfoodtest.base.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivityInteractor extends BaseInteractor{

    @Inject
    MainActivityInteractor() {
    }

    public void getList(Consumer<MainActivityState> onSuccess, Consumer<Throwable> onFailure){
        Disposable disposable = Observable.just("")
                .map(s-> new MainActivityState(1))
                .singleOrError()
                .subscribeOn(mSchedulersFacade.io())
                .subscribe(onSuccess, onFailure);

        mCompositeDisposable.add(disposable);
    }

    public Observable<MainActivityState> getList(){
        return Observable.just(new MainActivityState(1));
    }
}

package com.worldsnas.snappfoodtest.manager.pref;


import com.f2prateek.rx.preferences2.RxSharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public final class AppPrefManager implements PrefManager {

    @Inject
    RxSharedPreferences mRxPref;

    @Inject
    AppPrefManager() {
    }

    @Override
    public Observable<String> getUserLoggedInMode() {
        return mRxPref.getString("login_type").asObservable();
    }

    @Override
    public void setUserLoggedInMode(String mode) {
        mRxPref.getString("login_type").set(mode);
    }

    @Override
    public Observable<String> getRegex() {
        return mRxPref.getString("regex").asObservable();
    }

    @Override
    public void setRegex(String regex) {
        mRxPref.getString("regex").set(regex);
    }

    @Override
    public Observable<String> getCurrentUserName() {
         return mRxPref.getString("user_name").asObservable();
    }

    @Override
    public void setUserName(String userName) {
        mRxPref.getString("user_name").set(userName);
    }

    @Override
    public Observable<String> getCurrentStatus() {
        return mRxPref.getString("user_status").asObservable();
    }

    @Override
    public void setUserStatus(String userStatus) {
        mRxPref.getString("user_status").set(userStatus);
    }

    @Override
    public void setUserId(int userId) {
        mRxPref.getInteger("user_id").set(userId);
    }

    @Override
    public Observable<Integer> getUserId() {
        return mRxPref.getInteger("user_id").asObservable();
    }

    @Override
    public void setUserPhone(String phone) {
        mRxPref.getString("user_phone").set(phone);
    }

    @Override
    public Observable<String> getUserPhone() {
        return mRxPref.getString("user_phone").asObservable();
    }
}

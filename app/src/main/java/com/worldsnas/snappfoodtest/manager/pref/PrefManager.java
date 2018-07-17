package com.worldsnas.snappfoodtest.manager.pref;

import io.reactivex.Observable;


@SuppressWarnings("unused")
public interface PrefManager {

    Observable<String> getUserLoggedInMode();

    void setUserLoggedInMode(@LoginType String mode);

    Observable<String> getRegex();

    void setRegex(String regex);

    Observable<String> getCurrentUserName();

    void setUserName(String userName);

    Observable<String> getCurrentStatus();

    void setUserStatus(String userStatus);

    void setUserId(int userId);

    Observable<Integer> getUserId();

    void setUserPhone(String phone);

    Observable<String> getUserPhone();
}

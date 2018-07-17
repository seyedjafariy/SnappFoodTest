package com.worldsnas.snappfoodtest.receiver;

import com.worldsnas.snappfoodtest.app.App;
import com.worldsnas.snappfoodtest.manager.pref.PrefManager;
import com.worldsnas.snappfoodtest.manager.rest.RestManager;

import javax.inject.Inject;

public class OneSignalNotificationHandler  {

    private final App mContext;

    private final RestManager mRestManager;

    private final PrefManager mPrefManager;

    @Inject
    OneSignalNotificationHandler(App context, RestManager restManager, PrefManager prefManager) {
        this.mContext = context;
        mRestManager = restManager;
        mPrefManager = prefManager;
    }

}

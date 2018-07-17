package com.worldsnas.snappfoodtest.manager.rest;


import com.worldsnas.snappfoodtest.app.network.Api;

import javax.inject.Inject;
import javax.inject.Singleton;

@SuppressWarnings("WeakerAccess")
@Singleton
public final class AppRestManager implements RestManager {

    @Inject
    Api mApi;

    @Inject
    public AppRestManager() {
    }
}
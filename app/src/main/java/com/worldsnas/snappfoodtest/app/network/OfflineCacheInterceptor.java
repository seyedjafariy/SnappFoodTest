package com.worldsnas.snappfoodtest.app.network;

import android.content.Context;
import android.support.annotation.NonNull;

import com.worldsnas.snappfoodtest.app.App;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class OfflineCacheInterceptor implements Interceptor{

    private final Context context;

    @Inject
    OfflineCacheInterceptor(App context) {
        this.context = context;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();

        if (!NetworkUtil.isNetworkAvailable(context)) {
            CacheControl cacheControl = new CacheControl.Builder()
                    .maxStale(7, TimeUnit.DAYS)
                    .build();

            request = request.newBuilder()
                    .cacheControl(cacheControl)
                    .build();
        }
        return chain.proceed(request);
    }
}

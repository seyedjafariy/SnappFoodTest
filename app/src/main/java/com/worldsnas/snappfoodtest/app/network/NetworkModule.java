package com.worldsnas.snappfoodtest.app.network;

import com.worldsnas.snappfoodtest.moshi.MoshiAdapterFactory;
import com.worldsnas.snappfoodtest.rxutils.SchedulersFacade;
import com.squareup.moshi.Moshi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module(includes = {OkHttpModule.class})
public class NetworkModule {

    @Provides
    static Moshi provideTypeAdapter(){
        return new Moshi.Builder()
                .add(MoshiAdapterFactory.create())
                .build();
    }


    @Provides
    static Retrofit provideRestHelper(OkHttpClient client, Moshi moshi, SchedulersFacade scheduler) {
        return new Retrofit.Builder()
                .baseUrl(EndPoint.BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(scheduler.io()))
                .build();
    }

    @Provides
    @Singleton
    static Api provideApi(Retrofit retrofit){
        return retrofit.create(Api.class);
    }


}

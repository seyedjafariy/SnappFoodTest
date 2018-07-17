package com.worldsnas.snappfoodtest.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.multidex.MultiDex;

import com.worldsnas.snappfoodtest.crashlytics.CrashlyticsLogExceptionTree;
import com.worldsnas.snappfoodtest.manager.pref.PrefManager;
import com.worldsnas.snappfoodtest.manager.rest.RestManager;
import com.worldsnas.snappfoodtest.receiver.OneSignalNotificationHandler;
import com.worldsnas.snappfoodtest.rxutils.SchedulersFacade;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.dumpapp.plugins.CrashDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.FilesDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.HprofDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin;
import com.github.moduth.blockcanary.BlockCanary;
import com.github.moduth.blockcanary.BlockCanaryContext;
import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerApplication;
import jp.wasabeef.takt.Seat;
import jp.wasabeef.takt.Takt;
import timber.log.Timber;

import static com.worldsnas.snappfoodtest.BuildConfig.DEBUG;

public class App extends DaggerApplication {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @Inject
    RestManager mRestManager;
    @Inject
    PrefManager mPrefManager;
    @Inject
    SchedulersFacade mSchedulersFacade;
    @Inject
    OneSignalNotificationHandler mOneSignalNotificationHandler;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        initMultiDex();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initLeakCanary();

        initOneSignal();

        Fresco.initialize(this);

        initTimber();

        initStetho();

        initBlockCanary();

        initTakt();
    }

    private void initBlockCanary() {
        if (DEBUG) {
            BlockCanary.install(this, new BlockCanaryContext());
        }
    }

    private void initTakt() {
        if (DEBUG) {
            Takt.stock(this)
                    .seat(Seat.BOTTOM_RIGHT)
                    .interval(250)
                    .color(Color.WHITE)
                    .size(14f)
                    .alpha(.5f)
                    .play();
        }
    }

    private void initStetho() {
        if (DEBUG) {
            Stetho.initialize(Stetho.newInitializerBuilder(this)
                    .enableDumpapp(() -> new Stetho.DefaultDumperPluginsBuilder(App.this)
                            .provide(new CrashDumperPlugin())
                            .provide(new FilesDumperPlugin(App.this))
                            .provide(new HprofDumperPlugin(App.this))
                            .provide(new SharedPreferencesDumperPlugin(App.this))
                            .finish())
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                    .build());
        }
    }

    private void initTimber() {
        if (DEBUG)
            Timber.plant(new Timber.DebugTree());
        else
            Timber.plant(new CrashlyticsLogExceptionTree());
    }

    private void initOneSignal() {
//        OneSignal.startInit(this)
//                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
//                .setNotificationOpenedHandler(mOneSignalNotificationHandler)
//                .unsubscribeWhenNotificationsAreDisabled(true)
//                .init();
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    private void initMultiDex() {
//        if (DEBUG)
//            MultiDex.install(this);
    }

    @Override
    public void onTerminate() {
        if (DEBUG) {
            Takt.finish();
        }
        super.onTerminate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}

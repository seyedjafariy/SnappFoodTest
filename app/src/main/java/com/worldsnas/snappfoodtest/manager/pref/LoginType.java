package com.worldsnas.snappfoodtest.manager.pref;


import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.worldsnas.snappfoodtest.manager.pref.LoginConstants.LOGGED_IN;
import static com.worldsnas.snappfoodtest.manager.pref.LoginConstants.LOGGED_OUT;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        LOGGED_OUT,
        LOGGED_IN

})
public @interface LoginType {
}


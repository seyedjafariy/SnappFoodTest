package com.worldsnas.snappfoodtest.app;



import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

@SuppressWarnings("unused")
@Qualifier
@Retention(RetentionPolicy.SOURCE)
public  @interface ApplicationContext {
}
